package ms3.service.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import ms3.service.model.TrackAssignment;
import ms3.service.model.TrackAssignmentModel;
import ms3.service.model.TrackAssignmentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TrackAssignment service. Represents a row in the &quot;train_TrackAssignment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ms3.service.model.TrackAssignmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TrackAssignmentImpl}.
 * </p>
 *
 * @author jackt
 * @see TrackAssignmentImpl
 * @see ms3.service.model.TrackAssignment
 * @see ms3.service.model.TrackAssignmentModel
 * @generated
 */
@JSON(strict = true)
public class TrackAssignmentModelImpl extends BaseModelImpl<TrackAssignment>
    implements TrackAssignmentModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a track assignment model instance should use the {@link ms3.service.model.TrackAssignment} interface instead.
     */
    public static final String TABLE_NAME = "train_TrackAssignment";
    public static final Object[][] TABLE_COLUMNS = {
            { "trackAssignmentId", Types.BIGINT },
            { "trackId", Types.BIGINT },
            { "userScreenName", Types.VARCHAR },
            { "assignmentIdList", Types.VARCHAR },
            { "dateAssigned", Types.VARCHAR },
            { "admin", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table train_TrackAssignment (trackAssignmentId LONG not null primary key,trackId LONG,userScreenName VARCHAR(75) null,assignmentIdList VARCHAR(75) null,dateAssigned VARCHAR(75) null,admin VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table train_TrackAssignment";
    public static final String ORDER_BY_JPQL = " ORDER BY trackAssignment.trackAssignmentId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY train_TrackAssignment.trackAssignmentId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.ms3.service.model.TrackAssignment"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.ms3.service.model.TrackAssignment"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.ms3.service.model.TrackAssignment"),
            true);
    public static long TRACKID_COLUMN_BITMASK = 1L;
    public static long USERSCREENNAME_COLUMN_BITMASK = 2L;
    public static long TRACKASSIGNMENTID_COLUMN_BITMASK = 4L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.ms3.service.model.TrackAssignment"));
    private static ClassLoader _classLoader = TrackAssignment.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            TrackAssignment.class
        };
    private long _trackAssignmentId;
    private long _trackId;
    private long _originalTrackId;
    private boolean _setOriginalTrackId;
    private String _userScreenName;
    private String _originalUserScreenName;
    private String _assignmentIdList;
    private String _dateAssigned;
    private String _admin;
    private long _columnBitmask;
    private TrackAssignment _escapedModel;

    public TrackAssignmentModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static TrackAssignment toModel(TrackAssignmentSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        TrackAssignment model = new TrackAssignmentImpl();

        model.setTrackAssignmentId(soapModel.getTrackAssignmentId());
        model.setTrackId(soapModel.getTrackId());
        model.setUserScreenName(soapModel.getUserScreenName());
        model.setAssignmentIdList(soapModel.getAssignmentIdList());
        model.setDateAssigned(soapModel.getDateAssigned());
        model.setAdmin(soapModel.getAdmin());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<TrackAssignment> toModels(
        TrackAssignmentSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<TrackAssignment> models = new ArrayList<TrackAssignment>(soapModels.length);

        for (TrackAssignmentSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _trackAssignmentId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setTrackAssignmentId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _trackAssignmentId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @JSON
    @Override
    public long getTrackAssignmentId() {
        return _trackAssignmentId;
    }

    @Override
    public void setTrackAssignmentId(long trackAssignmentId) {
        _trackAssignmentId = trackAssignmentId;
    }

    @JSON
    @Override
    public long getTrackId() {
        return _trackId;
    }

    @Override
    public void setTrackId(long trackId) {
        _columnBitmask |= TRACKID_COLUMN_BITMASK;

        if (!_setOriginalTrackId) {
            _setOriginalTrackId = true;

            _originalTrackId = _trackId;
        }

        _trackId = trackId;
    }

    public long getOriginalTrackId() {
        return _originalTrackId;
    }

    @JSON
    @Override
    public String getUserScreenName() {
        if (_userScreenName == null) {
            return StringPool.BLANK;
        } else {
            return _userScreenName;
        }
    }

    @Override
    public void setUserScreenName(String userScreenName) {
        _columnBitmask |= USERSCREENNAME_COLUMN_BITMASK;

        if (_originalUserScreenName == null) {
            _originalUserScreenName = _userScreenName;
        }

        _userScreenName = userScreenName;
    }

    public String getOriginalUserScreenName() {
        return GetterUtil.getString(_originalUserScreenName);
    }

    @JSON
    @Override
    public String getAssignmentIdList() {
        if (_assignmentIdList == null) {
            return StringPool.BLANK;
        } else {
            return _assignmentIdList;
        }
    }

    @Override
    public void setAssignmentIdList(String assignmentIdList) {
        _assignmentIdList = assignmentIdList;
    }

    @JSON
    @Override
    public String getDateAssigned() {
        if (_dateAssigned == null) {
            return StringPool.BLANK;
        } else {
            return _dateAssigned;
        }
    }

    @Override
    public void setDateAssigned(String dateAssigned) {
        _dateAssigned = dateAssigned;
    }

    @JSON
    @Override
    public String getAdmin() {
        if (_admin == null) {
            return StringPool.BLANK;
        } else {
            return _admin;
        }
    }

    @Override
    public void setAdmin(String admin) {
        _admin = admin;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            TrackAssignment.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public TrackAssignment toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (TrackAssignment) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        TrackAssignmentImpl trackAssignmentImpl = new TrackAssignmentImpl();

        trackAssignmentImpl.setTrackAssignmentId(getTrackAssignmentId());
        trackAssignmentImpl.setTrackId(getTrackId());
        trackAssignmentImpl.setUserScreenName(getUserScreenName());
        trackAssignmentImpl.setAssignmentIdList(getAssignmentIdList());
        trackAssignmentImpl.setDateAssigned(getDateAssigned());
        trackAssignmentImpl.setAdmin(getAdmin());

        trackAssignmentImpl.resetOriginalValues();

        return trackAssignmentImpl;
    }

    @Override
    public int compareTo(TrackAssignment trackAssignment) {
        long primaryKey = trackAssignment.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TrackAssignment)) {
            return false;
        }

        TrackAssignment trackAssignment = (TrackAssignment) obj;

        long primaryKey = trackAssignment.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        TrackAssignmentModelImpl trackAssignmentModelImpl = this;

        trackAssignmentModelImpl._originalTrackId = trackAssignmentModelImpl._trackId;

        trackAssignmentModelImpl._setOriginalTrackId = false;

        trackAssignmentModelImpl._originalUserScreenName = trackAssignmentModelImpl._userScreenName;

        trackAssignmentModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<TrackAssignment> toCacheModel() {
        TrackAssignmentCacheModel trackAssignmentCacheModel = new TrackAssignmentCacheModel();

        trackAssignmentCacheModel.trackAssignmentId = getTrackAssignmentId();

        trackAssignmentCacheModel.trackId = getTrackId();

        trackAssignmentCacheModel.userScreenName = getUserScreenName();

        String userScreenName = trackAssignmentCacheModel.userScreenName;

        if ((userScreenName != null) && (userScreenName.length() == 0)) {
            trackAssignmentCacheModel.userScreenName = null;
        }

        trackAssignmentCacheModel.assignmentIdList = getAssignmentIdList();

        String assignmentIdList = trackAssignmentCacheModel.assignmentIdList;

        if ((assignmentIdList != null) && (assignmentIdList.length() == 0)) {
            trackAssignmentCacheModel.assignmentIdList = null;
        }

        trackAssignmentCacheModel.dateAssigned = getDateAssigned();

        String dateAssigned = trackAssignmentCacheModel.dateAssigned;

        if ((dateAssigned != null) && (dateAssigned.length() == 0)) {
            trackAssignmentCacheModel.dateAssigned = null;
        }

        trackAssignmentCacheModel.admin = getAdmin();

        String admin = trackAssignmentCacheModel.admin;

        if ((admin != null) && (admin.length() == 0)) {
            trackAssignmentCacheModel.admin = null;
        }

        return trackAssignmentCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{trackAssignmentId=");
        sb.append(getTrackAssignmentId());
        sb.append(", trackId=");
        sb.append(getTrackId());
        sb.append(", userScreenName=");
        sb.append(getUserScreenName());
        sb.append(", assignmentIdList=");
        sb.append(getAssignmentIdList());
        sb.append(", dateAssigned=");
        sb.append(getDateAssigned());
        sb.append(", admin=");
        sb.append(getAdmin());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("ms3.service.model.TrackAssignment");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>trackAssignmentId</column-name><column-value><![CDATA[");
        sb.append(getTrackAssignmentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>trackId</column-name><column-value><![CDATA[");
        sb.append(getTrackId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userScreenName</column-name><column-value><![CDATA[");
        sb.append(getUserScreenName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>assignmentIdList</column-name><column-value><![CDATA[");
        sb.append(getAssignmentIdList());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dateAssigned</column-name><column-value><![CDATA[");
        sb.append(getDateAssigned());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>admin</column-name><column-value><![CDATA[");
        sb.append(getAdmin());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
