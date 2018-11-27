package com.datastax.ebc.fit.transformers;

import com.datastax.bdp.search.solr.FieldInputTransformer;
import com.datastax.ebc.fit.pojos.Apps;
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
            Apps apps = new Apps(fieldValue);

            SchemaField appsAppField = core.getLatestSchema().getFieldOrNull("apps_app");
            SchemaField appsImpField = core.getLatestSchema().getFieldOrNull("apps_imp");
            SchemaField appsRFlagField = core.getLatestSchema().getFieldOrNull("apps_rflag");
            SchemaField appsRCodeField = core.getLatestSchema().getFieldOrNull("apps_rcode");
            SchemaField appsReasonCodeField = core.getLatestSchema().getFieldOrNull("apps_reasoncode");
            SchemaField appsRetCodeField = core.getLatestSchema().getFieldOrNull("apps_retcode");

            if (null!=apps.getApp()) helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsAppField, apps.getApp());
            if (null!=apps.getImp()) helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsImpField, apps.getImp());
            if (null!=apps.getRflag()) helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsRFlagField, apps.getRflag());

            if (null!=apps.getRcode()) helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsRCodeField, apps.getRcode());
            if (null!=apps.getReasoncode()) helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsReasonCodeField, apps.getReasoncode());
            if (null!=apps.getRetcode()) helper.addFieldToDocument(core, core.getLatestSchema(), key, doc, appsRetCodeField, apps.getRetcode());

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}