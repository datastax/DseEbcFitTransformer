package com.datastax.ebc.fit.transformers;

import com.datastax.bdp.search.solr.FieldInputTransformer;
import com.datastax.ebc.fit.pojos.Apps;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.document.Document;
import org.apache.solr.core.SolrCore;
import org.apache.solr.schema.IndexSchema;
import org.apache.solr.schema.SchemaField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class TransactionSearchInputTransformer extends FieldInputTransformer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionSearchInputTransformer.class);


    @Override
    public boolean evaluate(String field) {
        return field.equals("apps");
    }

    @Override
    public void addFieldToDocument(SolrCore core, IndexSchema schema, String key, Document doc, SchemaField fieldInfo,
                                   String fieldValue, DocumentHelper helper) throws IOException {

        try {
            ObjectMapper mapper = new ObjectMapper();

            LOGGER.info("TransactionSearchInputTransformer called");
            LOGGER.info("fieldValue: " + fieldValue);

            String raw = StringUtils.replace(fieldValue, "||", "\",\"");
            String rawJson = StringUtils.replace(raw, ":", "\":\"");
            String validJson = StringUtils.replace(rawJson, "\'", "\"");

            Apps apps = mapper.readValue(validJson, Apps.class);

            // initial: {'app:ics_bill||imp:N||rflag:DINVALIDDATA||rcode:0||reasoncode:102||retcode:1261009'}
            // raw: {'app:ics_bill","imp:N","rflag:DINVALIDDATA","rcode:0","reasoncode:102","retcode:1261009'}
            // rawJson: {'app":"ics_bill","imp":"N","rflag":"DINVALIDDATA","rcode":"0","reasoncode":"102","retcode":"1261009'}
            // validJson: {"app":"ics_bill","imp":"N","rflag":"DINVALIDDATA","rcode":"0","reasoncode":"102","retcode":"1261009"}

            SchemaField appsAppField = core.getLatestSchema().getFieldOrNull("apps_app");
            SchemaField appsImpField = core.getLatestSchema().getFieldOrNull("apps_imp");
            SchemaField appsRFlagField = core.getLatestSchema().getFieldOrNull("apps_rflag");
            SchemaField appsRCodeField = core.getLatestSchema().getFieldOrNull("apps_rcode");
            SchemaField appsReasonCodeField = core.getLatestSchema().getFieldOrNull("apps_reasoncode");
            SchemaField appsRetCodeField = core.getLatestSchema().getFieldOrNull("apps_retcode");

            helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsAppField, apps.getApp());
            helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsImpField, apps.getImp());
            helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsRFlagField, apps.getRflag());

            helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsRCodeField, apps.getRcode());
            helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsReasonCodeField, apps.getReasoncode());
            helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsRetCodeField, apps.getRetcode());

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}