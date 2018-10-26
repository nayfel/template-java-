package ms3.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TrackAssignment}.
 * </p>
 *
 * @author jackt
 * @see TrackAssignment
 * @generated
 */
public class TrackAssignmentWrapper implements TrackAssignment,
    ModelWrapper<TrackAssignment> {
    private TrackAssignment _trackAssignment;

    public TrackAssignmentWrapper(TrackAssignment trackAssignment) {
        _trackAssignment = trackAssignment;
    }

    @Override
    public Class<?> getModelClass() {
        return TrackAssignment.class;
    }

    @Override
    public String getModelClassName() {
        return TrackAssignment.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("trackAssignmentId", getTrackAssignmentId());
        attributes.put("trackId", getTrackId());
        attributes.put("userScreenName", getUserScreenName());
        attributes.put("assignmentIdList", getAssignmentIdList());
        attributes.put("dateAssigned", getDateAssigned());
        attributes.put("admin", getAdmin());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long trackAssignmentId = (Long) attributes.get("trackAssignmentId");

        if (trackAssignmentId != null) {
            setTrackAssignmentId(trackAssignmentId);
        }

        Long trackId = (Long) attributes.get("trackId");

        if (trackId != null) {
            setTrackId(trackId);
        }

        String userScreenName = (String) attributes.get("userScreenName");

        if (userScreenName != null) {
            setUserScreenName(userScreenName);
        }

        String assignmentIdList = (String) attributes.get("assignmentIdList");

        if (assignmentIdList != null) {
            setAssignmentIdList(assignmentIdList);
        }

        String dateAssigned = (String) attributes.get("dateAssigned");

        if (dateAssigned != null) {
            setDateAssigned(dateAssigned);
        }

        String admin = (String) attributes.get("admin");

        if (admin != null) {
            setAdmin(admin);
        }
    }

    /**
    * Returns the primary key of this track assignment.
    *
    * @return the primary key of this track assignment
    */
    @Override
    public long getPrimaryKey() {
        return _trackAssignment.getPrimaryKey();
    }

    /**
    * Sets the primary key of this track assignment.
    *
    * @param primaryKey the primary key of this track assignment
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _trackAssignment.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the track assignment ID of this track assignment.
    *
    * @return the track assignment ID of this track assignment
    */
    @Override
    public long getTrackAssignmentId() {
        return _trackAssignment.getTrackAssignmentId();
    }

    /**
    * Sets the track assignment ID of this track assignment.
    *
    * @param trackAssignmentId the track assignment ID of this track assignment
    */
    @Override
    public void setTrackAssignmentId(long trackAssignmentId) {
        _trackAssignment.setTrackAssignmentId(trackAssignmentId);
    }

    /**
    * Returns the track ID of this track assignment.
    *
    * @return the track ID of this track assignment
    */
    @Override
    public long getTrackId() {
        return _trackAssignment.getTrackId();
    }

    /**
    * Sets the track ID of this track assignment.
    *
    * @param trackId the track ID of this track assignment
    */
    @Override
    public void setTrackId(long trackId) {
        _trackAssignment.setTrackId(trackId);
    }

    /**
    * Returns the user screen name of this track assignment.
    *
    * @return the user screen name of this track assignment
    */
    @Override
    public java.lang.String getUserScreenName() {
        return _trackAssignment.getUserScreenName();
    }

    /**
    * Sets the user screen name of this track assignment.
    *
    * @param userScreenName the user screen name of this track assignment
    */
    @Override
    public void setUserScreenName(java.lang.String userScreenName) {
        _trackAssignment.setUserScreenName(userScreenName);
    }

    /**
    * Returns the assignment ID list of this track assignment.
    *
    * @return the assignment ID list of this track assignment
    */
    @Override
    public java.lang.String getAssignmentIdList() {
        return _trackAssignment.getAssignmentIdList();
    }

    /**
    * Sets the assignment ID list of this track assignment.
    *
    * @param assignmentIdList the assignment ID list of this track assignment
    */
    @Override
    public void setAssignmentIdList(java.lang.String assignmentIdList) {
        _trackAssignment.setAssignmentIdList(assignmentIdList);
    }

    /**
    * Returns the date assigned of this track assignment.
    *
    * @return the date assigned of this track assignment
    */
    @Override
    public java.lang.String getDateAssigned() {
        return _trackAssignment.getDateAssigned();
    }

    /**
    * Sets the date assigned of this track assignment.
    *
    * @param dateAssigned the date assigned of this track assignment
    */
    @Override
    public void setDateAssigned(java.lang.String dateAssigned) {
        _trackAssignment.setDateAssigned(dateAssigned);
    }

    /**
    * Returns the admin of this track assignment.
    *
    * @return the admin of this track assignment
    */
    @Override
    public java.lang.String getAdmin() {
        return _trackAssignment.getAdmin();
    }

    /**
    * Sets the admin of this track assignment.
    *
    * @param admin the admin of this track assignment
    */
    @Override
    public void setAdmin(java.lang.String admin) {
        _trackAssignment.setAdmin(admin);
    }

    @Override
    public boolean isNew() {
        return _trackAssignment.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _trackAssignment.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _trackAssignment.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _trackAssignment.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _trackAssignment.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _trackAssignment.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _trackAssignment.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _trackAssignment.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _trackAssignment.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _trackAssignment.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _trackAssignment.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new TrackAssignmentWrapper((TrackAssignment) _trackAssignment.clone());
    }

    @Override
    public int compareTo(ms3.service.model.TrackAssignment trackAssignment) {
        return _trackAssignment.compareTo(trackAssignment);
    }

    @Override
    public int hashCode() {
        return _trackAssignment.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ms3.service.model.TrackAssignment> toCacheModel() {
        return _trackAssignment.toCacheModel();
    }

    @Override
    public ms3.service.model.TrackAssignment toEscapedModel() {
        return new TrackAssignmentWrapper(_trackAssignment.toEscapedModel());
    }

    @Override
    public ms3.service.model.TrackAssignment toUnescapedModel() {
        return new TrackAssignmentWrapper(_trackAssignment.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _trackAssignment.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _trackAssignment.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _trackAssignment.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TrackAssignmentWrapper)) {
            return false;
        }

        TrackAssignmentWrapper trackAssignmentWrapper = (TrackAssignmentWrapper) obj;

        if (Validator.equals(_trackAssignment,
                    trackAssignmentWrapper._trackAssignment)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public TrackAssignment getWrappedTrackAssignment() {
        return _trackAssignment;
    }

    @Override
    public TrackAssignment getWrappedModel() {
        return _trackAssignment;
    }

    @Override
    public void resetOriginalValues() {
        _trackAssignment.resetOriginalValues();
    }
}
