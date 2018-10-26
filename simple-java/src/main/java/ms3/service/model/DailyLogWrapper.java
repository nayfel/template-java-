package ms3.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DailyLog}.
 * </p>
 *
 * @author jackt
 * @see DailyLog
 * @generated
 */
public class DailyLogWrapper implements DailyLog, ModelWrapper<DailyLog> {
    private DailyLog _dailyLog;

    public DailyLogWrapper(DailyLog dailyLog) {
        _dailyLog = dailyLog;
    }

    @Override
    public Class<?> getModelClass() {
        return DailyLog.class;
    }

    @Override
    public String getModelClassName() {
        return DailyLog.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("dailyLogId", getDailyLogId());
        attributes.put("assignment_id", getAssignment_id());
        attributes.put("date", getDate());
        attributes.put("accomplishments", getAccomplishments());
        attributes.put("roadblocks", getRoadblocks());
        attributes.put("plan", getPlan());
        attributes.put("notes", getNotes());
        attributes.put("hours", getHours());
        attributes.put("section", getSection());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long dailyLogId = (Long) attributes.get("dailyLogId");

        if (dailyLogId != null) {
            setDailyLogId(dailyLogId);
        }

        Long assignment_id = (Long) attributes.get("assignment_id");

        if (assignment_id != null) {
            setAssignment_id(assignment_id);
        }

        String date = (String) attributes.get("date");

        if (date != null) {
            setDate(date);
        }

        String accomplishments = (String) attributes.get("accomplishments");

        if (accomplishments != null) {
            setAccomplishments(accomplishments);
        }

        String roadblocks = (String) attributes.get("roadblocks");

        if (roadblocks != null) {
            setRoadblocks(roadblocks);
        }

        String plan = (String) attributes.get("plan");

        if (plan != null) {
            setPlan(plan);
        }

        String notes = (String) attributes.get("notes");

        if (notes != null) {
            setNotes(notes);
        }

        Double hours = (Double) attributes.get("hours");

        if (hours != null) {
            setHours(hours);
        }

        String section = (String) attributes.get("section");

        if (section != null) {
            setSection(section);
        }
    }

    /**
    * Returns the primary key of this daily log.
    *
    * @return the primary key of this daily log
    */
    @Override
    public long getPrimaryKey() {
        return _dailyLog.getPrimaryKey();
    }

    /**
    * Sets the primary key of this daily log.
    *
    * @param primaryKey the primary key of this daily log
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _dailyLog.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the daily log ID of this daily log.
    *
    * @return the daily log ID of this daily log
    */
    @Override
    public long getDailyLogId() {
        return _dailyLog.getDailyLogId();
    }

    /**
    * Sets the daily log ID of this daily log.
    *
    * @param dailyLogId the daily log ID of this daily log
    */
    @Override
    public void setDailyLogId(long dailyLogId) {
        _dailyLog.setDailyLogId(dailyLogId);
    }

    /**
    * Returns the assignment_id of this daily log.
    *
    * @return the assignment_id of this daily log
    */
    @Override
    public long getAssignment_id() {
        return _dailyLog.getAssignment_id();
    }

    /**
    * Sets the assignment_id of this daily log.
    *
    * @param assignment_id the assignment_id of this daily log
    */
    @Override
    public void setAssignment_id(long assignment_id) {
        _dailyLog.setAssignment_id(assignment_id);
    }

    /**
    * Returns the date of this daily log.
    *
    * @return the date of this daily log
    */
    @Override
    public java.lang.String getDate() {
        return _dailyLog.getDate();
    }

    /**
    * Sets the date of this daily log.
    *
    * @param date the date of this daily log
    */
    @Override
    public void setDate(java.lang.String date) {
        _dailyLog.setDate(date);
    }

    /**
    * Returns the accomplishments of this daily log.
    *
    * @return the accomplishments of this daily log
    */
    @Override
    public java.lang.String getAccomplishments() {
        return _dailyLog.getAccomplishments();
    }

    /**
    * Sets the accomplishments of this daily log.
    *
    * @param accomplishments the accomplishments of this daily log
    */
    @Override
    public void setAccomplishments(java.lang.String accomplishments) {
        _dailyLog.setAccomplishments(accomplishments);
    }

    /**
    * Returns the roadblocks of this daily log.
    *
    * @return the roadblocks of this daily log
    */
    @Override
    public java.lang.String getRoadblocks() {
        return _dailyLog.getRoadblocks();
    }

    /**
    * Sets the roadblocks of this daily log.
    *
    * @param roadblocks the roadblocks of this daily log
    */
    @Override
    public void setRoadblocks(java.lang.String roadblocks) {
        _dailyLog.setRoadblocks(roadblocks);
    }

    /**
    * Returns the plan of this daily log.
    *
    * @return the plan of this daily log
    */
    @Override
    public java.lang.String getPlan() {
        return _dailyLog.getPlan();
    }

    /**
    * Sets the plan of this daily log.
    *
    * @param plan the plan of this daily log
    */
    @Override
    public void setPlan(java.lang.String plan) {
        _dailyLog.setPlan(plan);
    }

    /**
    * Returns the notes of this daily log.
    *
    * @return the notes of this daily log
    */
    @Override
    public java.lang.String getNotes() {
        return _dailyLog.getNotes();
    }

    /**
    * Sets the notes of this daily log.
    *
    * @param notes the notes of this daily log
    */
    @Override
    public void setNotes(java.lang.String notes) {
        _dailyLog.setNotes(notes);
    }

    /**
    * Returns the hours of this daily log.
    *
    * @return the hours of this daily log
    */
    @Override
    public double getHours() {
        return _dailyLog.getHours();
    }

    /**
    * Sets the hours of this daily log.
    *
    * @param hours the hours of this daily log
    */
    @Override
    public void setHours(double hours) {
        _dailyLog.setHours(hours);
    }

    /**
    * Returns the section of this daily log.
    *
    * @return the section of this daily log
    */
    @Override
    public java.lang.String getSection() {
        return _dailyLog.getSection();
    }

    /**
    * Sets the section of this daily log.
    *
    * @param section the section of this daily log
    */
    @Override
    public void setSection(java.lang.String section) {
        _dailyLog.setSection(section);
    }

    @Override
    public boolean isNew() {
        return _dailyLog.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _dailyLog.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _dailyLog.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _dailyLog.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _dailyLog.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _dailyLog.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _dailyLog.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _dailyLog.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _dailyLog.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _dailyLog.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _dailyLog.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new DailyLogWrapper((DailyLog) _dailyLog.clone());
    }

    @Override
    public int compareTo(ms3.service.model.DailyLog dailyLog) {
        return _dailyLog.compareTo(dailyLog);
    }

    @Override
    public int hashCode() {
        return _dailyLog.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ms3.service.model.DailyLog> toCacheModel() {
        return _dailyLog.toCacheModel();
    }

    @Override
    public ms3.service.model.DailyLog toEscapedModel() {
        return new DailyLogWrapper(_dailyLog.toEscapedModel());
    }

    @Override
    public ms3.service.model.DailyLog toUnescapedModel() {
        return new DailyLogWrapper(_dailyLog.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _dailyLog.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _dailyLog.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _dailyLog.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DailyLogWrapper)) {
            return false;
        }

        DailyLogWrapper dailyLogWrapper = (DailyLogWrapper) obj;

        if (Validator.equals(_dailyLog, dailyLogWrapper._dailyLog)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public DailyLog getWrappedDailyLog() {
        return _dailyLog;
    }

    @Override
    public DailyLog getWrappedModel() {
        return _dailyLog;
    }

    @Override
    public void resetOriginalValues() {
        _dailyLog.resetOriginalValues();
    }
}
