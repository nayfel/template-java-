package ms3.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Track service. Represents a row in the &quot;train_Track&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ms3.service.model.impl.TrackModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ms3.service.model.impl.TrackImpl}.
 * </p>
 *
 * @author jackt
 * @see Track
 * @see ms3.service.model.impl.TrackImpl
 * @see ms3.service.model.impl.TrackModelImpl
 * @generated
 */
public interface TrackModel extends BaseModel<Track> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a track model instance should use the {@link Track} interface instead.
     */

    /**
     * Returns the primary key of this track.
     *
     * @return the primary key of this track
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this track.
     *
     * @param primaryKey the primary key of this track
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the track ID of this track.
     *
     * @return the track ID of this track
     */
    public long getTrackId();

    /**
     * Sets the track ID of this track.
     *
     * @param trackId the track ID of this track
     */
    public void setTrackId(long trackId);

    /**
     * Returns the title of this track.
     *
     * @return the title of this track
     */
    @AutoEscape
    public String getTitle();

    /**
     * Sets the title of this track.
     *
     * @param title the title of this track
     */
    public void setTitle(String title);

    /**
     * Returns the description of this track.
     *
     * @return the description of this track
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this track.
     *
     * @param description the description of this track
     */
    public void setDescription(String description);

    /**
     * Returns the course list of this track.
     *
     * @return the course list of this track
     */
    @AutoEscape
    public String getCourseList();

    /**
     * Sets the course list of this track.
     *
     * @param courseList the course list of this track
     */
    public void setCourseList(String courseList);

    /**
     * Returns the accreditation of this track.
     *
     * @return the accreditation of this track
     */
    @AutoEscape
    public String getAccreditation();

    /**
     * Sets the accreditation of this track.
     *
     * @param accreditation the accreditation of this track
     */
    public void setAccreditation(String accreditation);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(ms3.service.model.Track track);

    @Override
    public int hashCode();

    @Override
    public CacheModel<ms3.service.model.Track> toCacheModel();

    @Override
    public ms3.service.model.Track toEscapedModel();

    @Override
    public ms3.service.model.Track toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
