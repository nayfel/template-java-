package ms3.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ms3.service.service.ClpSerializer;
import ms3.service.service.TrackAssignmentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class TrackAssignmentClp extends BaseModelImpl<TrackAssignment>
    implements TrackAssignment {
    private long _trackAssignmentId;
    private long _trackId;
    private String _userScreenName;
    private String _assignmentIdList;
    private String _dateAssigned;
    private String _admin;
    private BaseModel<?> _trackAssignmentRemoteModel;
    private Class<?> _clpSerializerClass = ms3.service.service.ClpSerializer.class;

    public TrackAssignmentClp() {
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

    @Override
    public long getTrackAssignmentId() {
        return _trackAssignmentId;
    }

    @Override
    public void setTrackAssignmentId(long trackAssignmentId) {
        _trackAssignmentId = trackAssignmentId;

        if (_trackAssignmentRemoteModel != null) {
            try {
                Class<?> clazz = _trackAssignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setTrackAssignmentId",
                        long.class);

                method.invoke(_trackAssignmentRemoteModel, trackAssignmentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getTrackId() {
        return _trackId;
    }

    @Override
    public void setTrackId(long trackId) {
        _trackId = trackId;

        if (_trackAssignmentRemoteModel != null) {
            try {
                Class<?> clazz = _trackAssignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setTrackId", long.class);

                method.invoke(_trackAssignmentRemoteModel, trackId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserScreenName() {
        return _userScreenName;
    }

    @Override
    public void setUserScreenName(String userScreenName) {
        _userScreenName = userScreenName;

        if (_trackAssignmentRemoteModel != null) {
            try {
                Class<?> clazz = _trackAssignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setUserScreenName",
                        String.class);

                method.invoke(_trackAssignmentRemoteModel, userScreenName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAssignmentIdList() {
        return _assignmentIdList;
    }

    @Override
    public void setAssignmentIdList(String assignmentIdList) {
        _assignmentIdList = assignmentIdList;

        if (_trackAssignmentRemoteModel != null) {
            try {
                Class<?> clazz = _trackAssignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setAssignmentIdList",
                        String.class);

                method.invoke(_trackAssignmentRemoteModel, assignmentIdList);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDateAssigned() {
        return _dateAssigned;
    }

    @Override
    public void setDateAssigned(String dateAssigned) {
        _dateAssigned = dateAssigned;

        if (_trackAssignmentRemoteModel != null) {
            try {
                Class<?> clazz = _trackAssignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setDateAssigned", String.class);

                method.invoke(_trackAssignmentRemoteModel, dateAssigned);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAdmin() {
        return _admin;
    }

    @Override
    public void setAdmin(String admin) {
        _admin = admin;

        if (_trackAssignmentRemoteModel != null) {
            try {
                Class<?> clazz = _trackAssignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setAdmin", String.class);

                method.invoke(_trackAssignmentRemoteModel, admin);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getTrackAssignmentRemoteModel() {
        return _trackAssignmentRemoteModel;
    }

    public void setTrackAssignmentRemoteModel(
        BaseModel<?> trackAssignmentRemoteModel) {
        _trackAssignmentRemoteModel = trackAssignmentRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _trackAssignmentRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_trackAssignmentRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            TrackAssignmentLocalServiceUtil.addTrackAssignment(this);
        } else {
            TrackAssignmentLocalServiceUtil.updateTrackAssignment(this);
        }
    }

    @Override
    public TrackAssignment toEscapedModel() {
        return (TrackAssignment) ProxyUtil.newProxyInstance(TrackAssignment.class.getClassLoader(),
            new Class[] { TrackAssignment.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        TrackAssignmentClp clone = new TrackAssignmentClp();

        clone.setTrackAssignmentId(getTrackAssignmentId());
        clone.setTrackId(getTrackId());
        clone.setUserScreenName(getUserScreenName());
        clone.setAssignmentIdList(getAssignmentIdList());
        clone.setDateAssigned(getDateAssigned());
        clone.setAdmin(getAdmin());

        return clone;
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

        if (!(obj instanceof TrackAssignmentClp)) {
            return false;
        }

        TrackAssignmentClp trackAssignment = (TrackAssignmentClp) obj;

        long primaryKey = trackAssignment.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
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
