package com.ktb.app.pms.commonlibrary.config.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.ktb.app.pms.commonlibrary.model.lookup.LookupResponse;
import com.ktb.app.pms.commonlibrary.model.requestCC.RequestCCResponse;
import com.ktb.app.pms.commonlibrary.model.requestDetail.RequestDetailFilesModel;
import com.ktb.app.pms.commonlibrary.model.requestDetail.RequestDetailHeadersModel;
import com.ktb.app.pms.commonlibrary.model.requestType.RequestTypeResponse;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public abstract class ShareBaseRepository {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public List<Object> procedureMapToList(Map<String, Object> mapResult, Object pojo) throws Exception {
		List<Object> resultList = new ArrayList<Object>();

		for (Map.Entry<String, Object> entry : mapResult.entrySet()) {
        	List<Object> objList = (List<Object>) (Object) entry.getValue();

        	resultList = this.objectListToPojoList(objList, pojo);
        	break;
        }
		return resultList;
	}

	private List<Object> objectListToPojoList(List<Object> objList, Object pojo) {
		List<Object> resultList = new ArrayList<Object>();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		JsonElement jsonElement = gson.toJsonTree(objList);
		if(pojo instanceof RequestTypeResponse){
			resultList = (List<Object>) (Object) Arrays.asList(gson.fromJson(jsonElement, RequestTypeResponse[].class));
        } else if(pojo instanceof LookupResponse){
        	resultList = (List<Object>) (Object) Arrays.asList(gson.fromJson(jsonElement, LookupResponse[].class));
        } else if(pojo instanceof RequestCCResponse){
			resultList = (List<Object>) (Object) Arrays.asList(gson.fromJson(jsonElement, RequestCCResponse[].class));
		} else if(pojo instanceof RequestDetailHeadersModel){
			resultList = (List<Object>) (Object) Arrays.asList(gson.fromJson(jsonElement, RequestDetailHeadersModel[].class));
		} else if(pojo instanceof RequestDetailFilesModel){
			resultList = (List<Object>) (Object) Arrays.asList(gson.fromJson(jsonElement, RequestDetailFilesModel[].class));
		}

		return resultList;
	}
	
//    public CallableStatement createCallableStatement(Connection con) throws SQLException {
//        CallableStatement callableStatement = con.prepareCall(" {call sp_OPC_REQUEST_TYPE (?,?)}");
//        callableStatement.setString(1, requestTypeRequest.getHqProcess());
//        callableStatement.setString(2, requestTypeRequest.getFixSpecialCC());
//        return callableStatement;
//    }

//	public List<Object> mapToEntityList(Map.Entry<String, Object> entry, T objResult) throws Exception {
////		Field[] fields = entity.class.getFields();
//		java.lang.reflect.Field[] allFields = objResult.getClass().getFields();
//
//		List<Object> listOriginal = (List<Object>) entry.getValue();
//		List<Object> listResult = new ArrayList<Object>();
//		for (Object objOriginal : listOriginal) {
//			for (java.lang.reflect.Field field : allFields) {
//		        Object currentFieldObject;
////		        try {
//		            currentFieldObject = field.get(objResult);
////		        } catch (Exception e) {
////		            return null;
////		        }
//		        boolean isWantedField = objOriginal.equals(currentFieldObject);
//		        if (isWantedField) {
//		            String fieldName = field.getName();
//		            
//		            Field field = objResult.getField(fieldName);
//
//		            field.set(obj,value);
//		        }
//		    }
//		}
//
//		return null;
//	}
	
//	private static String getFieldName(Object fieldObject, Object parent) {
//
//	    java.lang.reflect.Field[] allFields = parent.getClass().getFields();
//	    for (java.lang.reflect.Field field : allFields) {
//	        Object currentFieldObject;
//	        try {
//	            currentFieldObject = field.get(parent);
//	        } catch (Exception e) {
//	            return null;
//	        }
//	        boolean isWantedField = fieldObject.equals(currentFieldObject);
//	        if (isWantedField) {
//	            String fieldName = field.getName();
//	            return fieldName;
//	        }
//	    }
//	    return null;
//	}
	
//    @Autowired
//    protected NamedJdbcTemplate namedJdbcTemplate;
//
//    @Autowired
//    SimpleJdbcInsertTemplate simpleJdbcInsertTemplate;
//
//    @Autowired
//    @Lazy
//    ShareUserRepository shareUserRepository;
//
//    @Autowired
//    @Lazy
//    ShareScopeDataRepository shareScopeDataRepository;
//
//    @Autowired
//    @Lazy
//    DataStateRepository dataStateRepository;
//
//    @Autowired
//    @Lazy
//    DoChildTableRepository doChildTableRepository;
//
//    @Value("${app.database.schema:elgdba}")
//    private String schema;

//    public void setNamedJdbcTemplate(NamedJdbcTemplate template) {
//        this.namedJdbcTemplate = template;
//    }
//
//    public NamedJdbcTemplate getNamedJdbcTemplate() {
//        return namedJdbcTemplate;
//    }
//
//    public SimpleJdbcInsertTemplate getSimpleJdbcInsertTemplate() {
//        return simpleJdbcInsertTemplate;
//    }
//
//    public SimpleJdbcInsert getSimpleJdbcInsert(String tableName) {
//
//        if (!Validate.empty(tableName)) {
//            String[] tableNameArray = tableName.split("\\.");
//            if (tableNameArray.length == 2) {
//                tableName = tableNameArray[1];
//            }
//        }
//
//        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.getSimpleJdbcInsertTemplate().getJdbcTemplate());
//        simpleJdbcInsert.setSchemaName(schema);
//        simpleJdbcInsert.setTableName(tableName);
//        return simpleJdbcInsert;
//    }
//
//    public Integer execInsert(String tableName, Object pojoExec) throws Exception {
//
//        if (!Validate.empty(tableName)) {
//            String[] tableNameArray = tableName.split("\\.");
//            if (tableNameArray.length == 2) {
//                tableName = tableNameArray[1];
//            }
//        }
//
//        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.getSimpleJdbcInsertTemplate().getJdbcTemplate());
//        simpleJdbcInsert.setSchemaName(schema);
//        simpleJdbcInsert.setTableName(tableName);
//
//        //Field force update Entity "createdAt", "createdById", "version", "activeFlag"
//        if (pojoExec instanceof BaseEntity) {
//            BaseEntity baseEntity = (BaseEntity) pojoExec;
//            if (baseEntity.getActiveFlag() == null)
//                baseEntity.setActiveFlag("Y"); // กรณีข้อมูลรอแก้ไข ActiveFlag = N
//
//            BaseDataApproveEntity baseDataApproveEntity = new BaseDataApproveEntity();
//            if (pojoExec instanceof BaseDataApproveEntity) {
//                baseDataApproveEntity = (BaseDataApproveEntity) pojoExec;
//            }
//
//            if (baseEntity.getVersion() == null)
//                baseEntity.setVersion(0L);
//            if (baseEntity.getCreatedAt() == null)
//                baseEntity.setCreatedAt(DateUtil.getCurrent());
//            if (baseEntity.getCreatedById() == null)
//                baseEntity.setCreatedById(Long.valueOf(shareUserRepository.getCurrentUserKey()));
//
//        }
//
//
//        SqlParameterSource param = new BeanPropertySqlParameterSource(pojoExec);
//        Integer result = simpleJdbcInsert.execute(param);
//
//        if (result > 0) {
//            //TODO save history pojoExec
//        }
//
//        return result;
//    }
//
//    public Integer execInsertApproved(Object pojoExec, LwSuitFolders suitFolder) throws Exception {
//        Integer resultInsert = 0;
//        Integer resultExec = 0;
//        String dbTable = Util.getDataApproveKey(pojoExec).getDbTable();
//        String dbSeq = Util.getDataApproveKey(pojoExec).getDbSeq();
//
//        if (pojoExec instanceof BaseDataApproveEntity) {
//            SeUsers seUsers = shareUserRepository.getSeUsersOnly(shareUserRepository.getCurrentUserName());
//            BaseDataApproveEntity baseDataApproveEntity = (BaseDataApproveEntity) pojoExec;
//
//            String dataApproveKey = Util.getDataApproveKey(pojoExec).getKeyApprove();
//            Boolean confirmDataApproved = baseDataApproveEntity.getConfirmDataApprovedFlag() != null ? baseDataApproveEntity.getConfirmDataApprovedFlag() : false;
//
//            if (confirmDataApproved && baseDataApproveEntity.getId() != null) {//รองรับการอนุมัติข้อมูล รอเพิ่ม
//                log.info(" Approved : wait insert ");
//            } else if (baseDataApproveEntity.getId() != null) {// throw error when set Object.id
//                throw new Exception(" Error : Object.id should be null ");
//            } else {//set object execInsertApproved
//                baseDataApproveEntity.setId(getNextSeq(dbSeq));
//            }
//
//            if (confirmDataApproved) {
//                String confirmDataApprovedConst = baseDataApproveEntity.getConfirmDataApprovedConst();
//                if (LookupConst.DATA_APPROVED_PASS.equals(confirmDataApprovedConst)) {
//                    baseDataApproveEntity.setActiveFlag("Y");
//                    baseDataApproveEntity.setDataApprovedById(seUsers.getId());
//                    baseDataApproveEntity.setDataApprovedDate(DateUtil.getCurrent());
//                    baseDataApproveEntity.setDataApprovedConst(LookupConst.DATA_APPROVED_PASS);
//                    baseDataApproveEntity.setNewActiveFlag(null);
//                    baseDataApproveEntity.setOriginalDataId(null);
//                } else if (LookupConst.DATA_APPROVED_REJECT.equals(confirmDataApprovedConst)) { // อนุมัติไม่ผ่าน เป็นการอนุมัติข้อมูลที่มีสถานะ รอแก้ไขข้อมูล
//                    baseDataApproveEntity.setDataApprovedById(seUsers.getId());
//                    baseDataApproveEntity.setDataApprovedConst(LookupConst.DATA_APPROVED_REJECT);
//                    baseDataApproveEntity.setDataApprovedDate(DateUtil.getCurrent());
//                }
//                resultExec = execUpdate(dbTable, pojoExec, pojoExec);
//
//            } else if (shareScopeDataRepository.isDataApprove(seUsers, suitFolder, dataApproveKey)) {
//                log.info("execInsertApproved : DATA_APPROVED_WAIT");
//                baseDataApproveEntity.setActiveFlag("N");
//                baseDataApproveEntity.setNewActiveFlag("Y");
//                baseDataApproveEntity.setDataApprovedConst(LookupConst.DATA_APPROVED_WAIT);
//                resultExec = execInsert(dbTable, pojoExec);
//
//                Integer resultInsertChildData = doChildTableRepository.doChildData(pojoExec, "INSERT");
//                resultExec += resultInsertChildData;
//                log.info("resultInsertChildData = " + resultInsertChildData);
//            } else {
//
//                log.info("execInsertApproved : DATA_APPROVED_PASS");
//                baseDataApproveEntity.setActiveFlag("Y");
//                baseDataApproveEntity.setDataApprovedConst(LookupConst.DATA_APPROVED_PASS);
//                resultInsert = execInsert(dbTable, pojoExec);
//                resultExec = resultInsert;
//
//
//                Integer resultInsertChildData = doChildTableRepository.doChildData(pojoExec, "INSERT");
//                resultExec += resultInsertChildData;
//                log.info("resultInsertChildData = " + resultInsertChildData);
//
//            }
//
//        } else {
//            throw new Exception("Error : pojoExec not instanceof BaseDataApproveEntity");
//        }
//
//
//        if (resultInsert > 0) { // Update/Insert table 1.) LW_STATES 2) LW_SUIT_LAWYERS 3) update last_state ( LW_SUITS or LW_SUIT_FOLDER )
//            DataStateModel dataStateModel = dataStateRepository.updateStateCreate(pojoExec, suitFolder);
//            log.info("state create : " + StringUtil.objectToJson(dataStateModel));
//        }
//
//        return resultExec;
//    }
//
//    public Integer execUpdate(String tableName, Object pojoExec, Object pojoOldData) throws Exception {
//
//        Map<String, Object> params = new HashMap<>();
//
//        //KEY update Entity
//        List<String> keys = Arrays.asList("id");
//        List<String> ignoreField = new ArrayList<>();
//
//        if (pojoExec instanceof LwTestimonies) {
//            ignoreField = Arrays.asList("id", "newActiveFlag", "originalDataId");
//        } else if (pojoExec instanceof LwAppealates || pojoExec instanceof LwSupremes) {
//            ignoreField = Arrays.asList("activeFlag");
//        } else if (pojoExec instanceof LwSubpoenas) {
//            ignoreField = Arrays.asList("newActiveFlag , originalDataId");
//        }
//
//        //Setup KEY SQL Update
//        StringBuilder sqlBuilder = new StringBuilder("UPDATE ");
//        sqlBuilder.append(tableName);
//        sqlBuilder.append(" SET ");
//        boolean first = true;
//        Set<Field> requestFields = ReflectionUtils.getAllFields(pojoExec.getClass(), ReflectionUtils.withModifier(Modifier.PRIVATE));
//        for (Field field : requestFields) {
//            if (!keys.equals(Arrays.asList(field.getName())) && !ignoreField.stream().anyMatch(field.getName()::equals)) {
//                if (!first) {
//                    sqlBuilder.append(",");
//                }
//                first = false;
//                sqlBuilder.append(StringUtil.camelToSnake(field.getName()));
//                sqlBuilder.append(" = :");
//                sqlBuilder.append(field.getName());
//
//            }
//        }
//
//        //Setup KEY update Entity
//        first = true;
//        for (String key : keys) {
//            if (first) {
//                sqlBuilder.append(" WHERE ");
//            } else {
//                sqlBuilder.append(" AND ");
//            }
//            first = false;
//            sqlBuilder.append(key);
//            sqlBuilder.append("= :");
//            sqlBuilder.append(key);
//        }
//
//        //Check version update data สำหรับตรวจสอบการแก้ไขข้อมูลพร้อมกันในรายการเดียวกัน
//        if (pojoExec instanceof BaseEntity && pojoOldData instanceof BaseEntity) {
//            BaseEntity baseEntityUpdateData = (BaseEntity) pojoExec;
//            BaseEntity baseEntityOldData = (BaseEntity) pojoOldData;
//
//            Long versionUpdateData = baseEntityUpdateData.getVersion();
//            Long versionOldData = baseEntityOldData.getVersion();
//            if (versionUpdateData != null && versionUpdateData != versionOldData) {
//                throw new Exception(" Can not update data : update version difference ");
//            } else {
//                sqlBuilder.append(" AND VERSION = :versionUpdate ");
//                params.put("versionUpdate", versionOldData);
//            }
//            baseEntityUpdateData.setVersion(versionOldData + 1L);
//            baseEntityUpdateData.setUpdatedAt(DateUtil.getCurrent());
//            baseEntityUpdateData.setUpdatedById(Long.valueOf(shareUserRepository.getCurrentUserKey()));
//        }
//
//
//        //Setup params update Entity
//        Object objectValue = new Object();
//        for (Field field : requestFields) {
//            objectValue = StringUtil.runGetter(field, pojoExec);
//            String fieldName = field.getName();
//            params.put(fieldName, objectValue);
//        }
//
//        log.info("Params : " + StringUtil.objectToJson(params));
//
//        Integer result = getNamedJdbcTemplate().update(sqlBuilder.toString(), params);
//
//        if (result > 0 && pojoOldData != null) {
//            //TODO save history pojoExec and pojoOldData
//        }
//
//        return result;
//    }
//
//    public ExecUpdateModel execUpdateApproved(Object pojoExec, Object pojoOldData, LwSuitFolders suitFolder) throws Exception {
//
//        ExecUpdateModel result = new ExecUpdateModel();
//        Integer resultUpdate = 0;
//        Integer resultExec = 0;
//
//        Boolean destroyDataApprovedFlag = false;
//
//        if (pojoExec instanceof BaseDataApproveEntity) {
//            SeUsers seUsers = shareUserRepository.getSeUsersOnly(shareUserRepository.getCurrentUserName());
//            BaseDataApproveEntity baseDataApproveEntity = (BaseDataApproveEntity) pojoExec;
//
//            String dataApproveKey = Util.getDataApproveKey(pojoExec).getKeyApprove();
//            String dbTable = Util.getDataApproveKey(pojoExec).getDbTable();
//            String dbSeq = Util.getDataApproveKey(pojoExec).getDbSeq();
//            Long objId = baseDataApproveEntity.getId();
//
//            Boolean isDataApprove = shareScopeDataRepository.isDataApprove(seUsers, suitFolder, dataApproveKey);
//            Boolean isdataApprovedWait = LookupConst.DATA_APPROVED_WAIT.equalsIgnoreCase(baseDataApproveEntity.getDataApprovedConst()) ? true : false;
//            Boolean isFlagActive = "Y".equals(getActiveFlag(dbTable, objId)) ? true : false;
//            destroyDataApprovedFlag = baseDataApproveEntity.getDestroyDataApprovedFlag() != null ? baseDataApproveEntity.getDestroyDataApprovedFlag() : false;
//            Boolean confirmDataApprovedFlag = baseDataApproveEntity.getConfirmDataApprovedFlag() != null ? baseDataApproveEntity.getConfirmDataApprovedFlag() : false;
//
//            if (isFlagActive && isDataApprove && !isdataApprovedWait && !confirmDataApprovedFlag) { // กรณีที่ รอแก้ไขข้อมูล โดยระบบจะต้อง Clone ข้อมูลที่รอแก้ไขเพิ่มอีก 1 Record ( ข้อมูลนี้จะต้องได้รับการอนุมัติก่อนถึงจะมีการ Update ข้อมูลนั้นสำเร็จ )
//                baseDataApproveEntity.setActiveFlag("N");
//                baseDataApproveEntity.setDataApprovedConst(LookupConst.DATA_APPROVED_WAIT);
//                if (pojoExec instanceof CoCollaterals) {
//                    log.info("execUpdateApproved CoCollaterals : DATA_APPROVED_WAIT");
//                    CoCollaterals coCollaterals = (CoCollaterals) pojoExec;
//                    Long collId = getNextSeq(dbSeq);
//                    coCollaterals.setId(collId);
//                    coCollaterals.setNewChildFlag("Y");
//                    coCollaterals.setNewActiveFlag("Y");
//                    coCollaterals.setOriginalDataId(coCollaterals.getId());
//                    coCollaterals.setCreatedById(1L);
//                    coCollaterals.setUpdatedById(seUsers.getId());
//                    coCollaterals.setUpdatedAt(DateUtil.getCurrent());
//                } else {
//                    log.info(" execUpdateApproved :  DATA_APPROVED_WAIT");
//                    Long seqId = getNextSeq(dbSeq);
//                    baseDataApproveEntity.setId(seqId);
//                    baseDataApproveEntity.setUpdatedById(seUsers.getId());
//                    baseDataApproveEntity.setUpdatedAt(DateUtil.getCurrent());
//
//                    if (!destroyDataApprovedFlag) {
//                        baseDataApproveEntity.setNewActiveFlag("Y");
//                    } else if (destroyDataApprovedFlag) {
//                        baseDataApproveEntity.setNewActiveFlag("N");
//                    }
//
//                    baseDataApproveEntity.setOriginalDataId(objId);
//                }
//                resultExec += execInsert(dbTable, pojoExec);
//                result.setExecMode("INSERT");
//                result.setUpdateCount(resultExec);
//
//                Integer resultInsertChildData = doChildTableRepository.doChildData(pojoExec, "INSERT");
//                resultExec += resultInsertChildData;
//                log.info("resultInsertChildData = " + resultInsertChildData);
//
//            } else { // กรณีที่มีการ update ข้อมูลโดยไม่ต้องมีการอนุมัติ หรือ เป็นการอนุมัติข้อมูลที่มีสถานะ รอแก้ไขข้อมูล
//                String confirmDataApprovedConst = baseDataApproveEntity.getConfirmDataApprovedConst();
//                if (confirmDataApprovedFlag) {//มาจากหน้าจออนุมัติข้อมูล
//                    if (!destroyDataApprovedFlag) {// ทำรายการอนุมัติ รอแก้ไข
//                        if (LookupConst.DATA_APPROVED_PASS.equals(confirmDataApprovedConst)) {// อนุมัติผ่าน
//                            //1 delete all child data
//                            //2 select originalDataId
//                            //3 merge clone data to originalData
//                            //4 delete child original data
//                            //5 update child original data ( insert child original data )
//                            //6 delete record clone data ต้องเอาไว้ลำดับสุดท้ายเพราะ transection ยังต้องใช้ parentkey ในข้อมูลก่อนหน้า
//
//
//                            Integer resultDeleteChildData1 = doChildTableRepository.doChildData(pojoExec, "DELETE"); //1 delete child clone data
//                            resultExec += resultDeleteChildData1;
//                            log.info("resultDeleteChildData1 = " + resultDeleteChildData1);
//
//                            Long originalDataId = baseDataApproveEntity.getOriginalDataId();
//                            Object originalDataObj = getOriginalData(dbTable, originalDataId);//2 select originalDataId
//                            originalDataObj = pojoExec;
//                            BaseDataApproveEntity baseDataApproveEntityOriginalDataObj = (BaseDataApproveEntity) originalDataObj;
//                            baseDataApproveEntityOriginalDataObj.setId(originalDataId);
//                            resultExec += execUpdate(dbTable, pojoExec, null);//3 merge clone data to originalData
//
//                            Integer resultDeleteChildData2 = doChildTableRepository.doChildData(pojoExec, "DELETE"); //4 delete child original data
//                            resultExec += resultDeleteChildData2;
//                            log.info("resultDeleteChildData2 = " + resultDeleteChildData2);
//
//                            Integer resultInsertChildData = doChildTableRepository.doChildData(pojoExec, "UPDATE"); //5 update child original data ( insert child original data )
//                            resultExec += resultInsertChildData;
//                            log.info("resultInsertChildData = " + resultInsertChildData);
//
//                            resultExec += deleteDataByIdOrOriginalId(dbTable, objId, "id");//6 delete record clone data ต้องเอาไว้ลำดับสุดท้ายเพราะ transection ยังต้องใช้ parentkey ในข้อมูลก่อนหน้า
//
//                            result.setExecMode("UPDATE");
//                            result.setUpdateCount(resultExec);
//                            log.info(" execUpdate & Approved >> Status : " + confirmDataApprovedConst);
//
//                        } else if (LookupConst.DATA_APPROVED_REJECT.equals(confirmDataApprovedConst)) { // อนุมัติไม่ผ่าน
//                            baseDataApproveEntity.setDataApprovedById(seUsers.getId());
//                            baseDataApproveEntity.setDataApprovedConst(LookupConst.DATA_APPROVED_REJECT);
//                            baseDataApproveEntity.setDataApprovedDate(DateUtil.getCurrent());
//
//                            resultExec += execUpdate(dbTable, pojoExec, null);
//                            result.setExecMode("UPDATE");
//                            result.setUpdateCount(resultExec);
//                            log.info(" execUpdate & Approved >> Status : " + confirmDataApprovedConst);
//                        }
//
//                    } else {// ทำรายการอนุมัติ รอลบ
//                        if (LookupConst.DATA_APPROVED_PASS.equals(confirmDataApprovedConst)) {// อนุมัติผ่าน
//                            baseDataApproveEntity.setDataApprovedById(seUsers.getId());
//                            baseDataApproveEntity.setDataApprovedDate(DateUtil.getCurrent());
//                            baseDataApproveEntity.setDataApprovedConst(LookupConst.DATA_APPROVED_PASS);
//                            baseDataApproveEntity.setNewActiveFlag(null);
//                            baseDataApproveEntity.setOriginalDataId(null);
//                            baseDataApproveEntity.setActiveFlag("N");
//
//                            //ลบ Clone Record
//                            resultExec += deleteDataByIdOrOriginalId(dbTable, baseDataApproveEntity.getId(), "original");
//                        } else if (LookupConst.DATA_APPROVED_REJECT.equals(confirmDataApprovedConst)) { // อนุมัติไม่ผ่าน
//                            //Setup data สำหรับ Update clone data
//                            baseDataApproveEntity.setDataApprovedById(seUsers.getId());
//                            baseDataApproveEntity.setDataApprovedConst(LookupConst.DATA_APPROVED_REJECT);
//                            baseDataApproveEntity.setDataApprovedDate(DateUtil.getCurrent());
//
//                            //update clone record to DATA_APPROVED_REJECT
//                            destroyRejectApprove(dbTable, baseDataApproveEntity);
//
//                            //Setup data สำหรับ Update master data
//                            baseDataApproveEntity.setDataApprovedById(null);
//                            baseDataApproveEntity.setDataApprovedConst(LookupConst.DATA_APPROVED_PASS);
//                            baseDataApproveEntity.setDataApprovedDate(null);
//                        }
//
//                        resultExec += execUpdate(dbTable, pojoExec, null);
//                        result.setExecMode("UPDATE");
//                        result.setUpdateCount(resultExec);
//                        log.info(" execUpdate & Approved >> Status : " + confirmDataApprovedConst);
//                    }
//
//
//                } else { //update ข้อมูลโดยไม่ต้องมีการอนุมัติ
//
//                    if (!destroyDataApprovedFlag) {//มาจากการแก้ไขข้อมูล
//                        //1 delete child data
//                        //2 update domain data
//                        //3 update child data
//
//                        Integer resultDeleteChildData = doChildTableRepository.doChildData(pojoExec, "DELETE"); //1 delete child data
//                        resultExec += resultDeleteChildData;
//                        log.info("resultDeleteChildData = " + resultDeleteChildData);
//
//                        resultUpdate = execUpdate(dbTable, pojoExec, pojoOldData);//2 update domain data
//                        resultExec += resultUpdate;
//                        result.setExecMode("UPDATE");
//                        result.setUpdateCount(resultExec);
//                        log.info(" execUpdate :  DATA_APPROVED_PASS");
//
//
//                        Integer resultInsertChildData = doChildTableRepository.doChildData(pojoExec, "UPDATE"); //3 update child data
//                        resultExec += resultInsertChildData;
//                        log.info("resultInsertChildData = " + resultInsertChildData);
//                    } else {//มาจากการลบข้อมูล
//                        baseDataApproveEntity.setActiveFlag("N");
//                        resultUpdate = execUpdate(dbTable, pojoExec, pojoOldData);
//                    }
//
//                }
//
//
//                if (resultUpdate > 0 && !destroyDataApprovedFlag) { // Update/Insert table 1.) LW_STATES 2) LW_SUIT_LAWYERS 3) update last_state ( LW_SUITS or LW_SUIT_FOLDER )
//                    DataStateModel dataStateModel = dataStateRepository.updateStateUpdate(pojoExec, pojoOldData, suitFolder);
//                    log.info("state update  : " + StringUtil.objectToJson(dataStateModel));
//                }
//            }
//
//        } else {
//            throw new Exception("Error : pojoExec not instanceof BaseDataApproveEntity");
//        }
//
//        return result;
//
//    }
//
//    public ExecUpdateModel execDestroyApproved(Object pojoExec, Object pojoOldData, LwSuitFolders suitFolder) throws Exception {
//
//        ExecUpdateModel result = new ExecUpdateModel();
//
//        if (pojoExec instanceof BaseDataApproveEntity) {
//            SeUsers seUsers = shareUserRepository.getSeUsersOnly(shareUserRepository.getCurrentUserName());
//            BaseDataApproveEntity baseDataApproveEntity = (BaseDataApproveEntity) pojoExec;
//
//            String dataApproveKey = Util.getDataApproveKey(pojoExec).getKeyApprove();
//            Long objId = baseDataApproveEntity.getId();
//            Boolean isDataApprove = shareScopeDataRepository.isDataApprove(seUsers, suitFolder, dataApproveKey);
//            Boolean destroyDataApprovedFlag = baseDataApproveEntity.getDestroyDataApprovedFlag() != null ? baseDataApproveEntity.getDestroyDataApprovedFlag() : false;
//
//            baseDataApproveEntity.setDestroyDataApprovedFlag(true);
//            result = execUpdateApproved(pojoExec, pojoOldData, suitFolder);
//
//            if (destroyDataApprovedFlag || (!isDataApprove)) {
//                DataStateModel dataStateModel = dataStateRepository.updateStateDelete(pojoExec, pojoOldData, suitFolder);
//                log.info("state destroy  : " + StringUtil.objectToJson(dataStateModel));
//            }
//
//        } else {
//            throw new Exception("Error : pojoExec not instanceof BaseDataApproveEntity");
//        }
//
//        return result;
//
//    }
//
//    public Long getNextSeq(String seqName) {
//        StringBuilder sbSql = new StringBuilder();
//        sbSql.append("SELECT ").append(seqName).append(".NEXTVAL AS NEXTSEQ FROM DUAL ");
//
//        List<Long> nextSeq = getNamedJdbcTemplate().query(sbSql.toString(), (rs, rowNum) -> rs.getLong("NEXTSEQ"));
//
//        return nextSeq.get(0);
//    }
//
//    private String getActiveFlag(String dbTable, Long id) throws Exception {
//
//        StringBuilder sbSql = new StringBuilder();
//        sbSql.append("SELECT tableData.ID, tableData.ACTIVE_FLAG FROM ").append(dbTable).append(" tableData WHERE tableData.ID = :id  ");
//
//        Map<String, Object> param = new HashMap<>();
//        param.put("id", id);
//
//        log.info("params : " + StringUtil.objectToJson(param));
//
//        BaseEntity baseEntity = getNamedJdbcTemplate().query2Object(sbSql.toString(), param, new BeanPropertyRowMapper<>(BaseEntity.class));
//        return baseEntity.getActiveFlag();
//
//    }
//
//    private Object getOriginalData(String dbTable, Long id) throws Exception {
//
//        StringBuilder sbSql = new StringBuilder();
//        sbSql.append("SELECT tableData.* FROM ").append(dbTable).append(" tableData WHERE tableData.ID = :id  ");
//
//        Map<String, Object> param = new HashMap<>();
//        param.put("id", id);
//
//        log.info("params : " + StringUtil.objectToJson(param));
//
//        return getNamedJdbcTemplate().query2Object(sbSql.toString(), param, new BeanPropertyRowMapper<>(Object.class));
//
//    }
//
//
//    private Integer deleteDataByIdOrOriginalId(String dbTable, Long id, String delType) throws Exception {
//        StringBuilder query = new StringBuilder();
//        Map<String, Object> param = new HashMap<>();
//
//        query.append(" DELETE ").append(dbTable);
//        query.append(" WHERE 1=1 AND ");
//
//        if ("id".equals(delType)) {
//            query.append(" ID = :id  ");
//            param.put("id", id);
//        } else if ("original".equals(delType)) {
//            query.append(" ORIGINAL_DATA_ID = :originalId  ");
//            param.put("originalId", id);
//        } else {
//            throw new Exception(" Error : out of condition ");
//        }
//
//        log.info("Params : " + StringUtil.objectToJson(param));
//
//        return getNamedJdbcTemplate().update(query.toString(), param);
//    }
//
//    private Integer destroyRejectApprove(String dbTable, BaseDataApproveEntity baseDataApproveEntity) throws Exception {
//        StringBuilder query = new StringBuilder();
//        query.append(" update " + dbTable + " t2\n");
//        query.append(" set t2.DATA_APPROVED_REASON = :reason, \n");
//        query.append("    t2.DATA_APPROVED_BY_ID  = :userId, \n");
//        query.append("    t2.DATA_APPROVED_CONST  = :approvedConst, \n");
//        query.append("    t2.DATA_APPROVED_DATE   = :approveDate \n");
//        query.append(" where t2.id IN \n");
//        query.append("      ( select t1.ID from " + dbTable + " t1 where t1.ORIGINAL_DATA_ID = :originalId ) ");
//
//        Map<String, Object> param = new HashMap<>();
//        param.put("reason", baseDataApproveEntity.getDataApprovedReason());
//        param.put("userId", baseDataApproveEntity.getDataApprovedById());
//        param.put("approvedConst", baseDataApproveEntity.getDataApprovedConst());
//        param.put("approveDate", baseDataApproveEntity.getDataApprovedDate());
//        param.put("originalId", baseDataApproveEntity.getId());
//
//        log.info("Params : " + StringUtil.objectToJson(param));
//
//        return getNamedJdbcTemplate().update(query.toString(), param);
//    }

}
