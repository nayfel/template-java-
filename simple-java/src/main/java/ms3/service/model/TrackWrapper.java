package ms3.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Track}.
 * </p>
 *
 * @author jackt
 * @see Track
 * @generated
 */
public class TrackWrapper implements Track, ModelWrapper<Track> {
    private Track _track;

    public TrackWrapper(Track track) {
        _track = track;
    }

    @Override
    public Class<?> getModelClass() {
        return Track.class;
    }

    @Override
    public String getModelClassName() {
        return Track.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("trackId", getTrackId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("courseList", getCourseList());
        attributes.put("accreditation", getAccreditation());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long trackId = (Long) attributes.get("trackId");

        if (trackId != null) {
            setTrackId(trackId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String courseList = (String) attributes.get("courseList");

        if (courseList != null) {
            setCourseList(courseList);
        }

        String accreditation = (String) attributes.get("accreditation");

        if (accreditation != null) {
            setAccreditation(accreditation);
        }
    }

    /**
    * Returns the primary key of this track.
    *
    * @return the primary key of this track
    */
    @Override
    public long getPrimaryKey() {
        return _track.getPrimaryKey();
    }

    /**
    * Sets the primary key of this track.
    *
    * @param primaryKey the primary key of this track
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _track.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the track ID of this track.
    *
    * @return the track ID of this track
    */
    @Override
    public long getTrackId() {
        return _track.getTrackId();
    }

    /**
    * Sets the track ID of this track.
    *
    * @param trackId the track ID of this track
    */
    @Override
    public void setTrackId(long trackId) {
        _track.setTrackId(trackId);
    }

    /**
    * Returns the title of this track.
    *
    * @return the title of this track
    */
    @Override
    public java.lang.String getTitle() {
        return _track.getTitle();
    }

    /**
    * Sets the title of this track.
    *
    * @param title the title of this track
    */
    @Override
    public void setTitle(java.lang.String title) {
        _track.setTitle(title);
    }

    /**
    * Returns the description of this track.
    *
    * @return the description of this track
    */
    @Override
    public java.lang.String getDescription() {
        return _track.getDescription();
    }

    /**
    * Sets the description of this track.
    *
    * @param description the description of this track
    */
    @Override
    public void setDescription(java.lang.String description) {
        _track.setDescription(description);
    }

    /**
    * Returns the course list of this track.
    *
    * @return the course list of this track
    */
    @Override
    public java.lang.String getCourseList() {
        return _track.getCourseList();
    }

    /**
    * Sets the course list of this track.
    *
    * @param courseList the course list of this track
    */
    @Override
    public void setCourseList(java.lang.String courseList) {
        _track.setCourseList(courseList);
    }

    /**
    * Returns the accreditation of this track.
    *
    * @return the accreditation of this track
    */
    @Override
    public java.lang.String getAccreditation() {
        return _track.getAccreditation();
    }

    /**
    * Sets the accreditation of this track.
    *
    * @param accreditation the accreditation of this track
    */
    @Override
    public void setAccreditation(java.lang.String accreditation) {
        _track.setAccreditation(accreditation);
    }

    @Override
    public boolean isNew() {
        return _track.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _track.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _track.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _track.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _track.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _track.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _track.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _track.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _track.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _track.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _track.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new TrackWrapper((Track) _track.clone());
    }

    @Override
    public int compareTo(ms3.service.model.Track track) {
        return _track.compareTo(track);
    }

    @Override
    public int hashCode() {
        return _track.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ms3.service.model.Track> toCacheModel() {
        return _track.toCacheModel();
    }

    @Override
    public ms3.service.model.Track toEscapedModel() {
        return new TrackWrapper(_track.toEscapedModel());
    }

    @Override
    public ms3.service.model.Track toUnescapedModel() {
        return new TrackWrapper(_track.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _track.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _track.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _track.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TrackWrapper)) {
            return false;
        }

        TrackWrapper trackWrapper = (TrackWrapper) obj;

        if (Validator.equals(_track, trackWrapper._track)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Track getWrappedTrack() {
        return _track;
    }

    @Override
    public Track getWrappedModel() {
        return _track;
    }

    @Override
    public void resetOriginalValues() {
        _track.resetOriginalValues();
    }
}
