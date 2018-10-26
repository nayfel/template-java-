package ms3.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ms3.service.service.ClpSerializer;
import ms3.service.service.TrackLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class TrackClp extends BaseModelImpl<Track> implements Track {
    private long _trackId;
    private String _title;
    private String _description;
    private String _courseList;
    private String _accreditation;
    private BaseModel<?> _trackRemoteModel;
    private Class<?> _clpSerializerClass = ms3.service.service.ClpSerializer.class;

    public TrackClp() {
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
    public long getPrimaryKey() {
        return _trackId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setTrackId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _trackId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getTrackId() {
        return _trackId;
    }

    @Override
    public void setTrackId(long trackId) {
        _trackId = trackId;

        if (_trackRemoteModel != null) {
            try {
                Class<?> clazz = _trackRemoteModel.getClass();

                Method method = clazz.getMethod("setTrackId", long.class);

                method.invoke(_trackRemoteModel, trackId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_trackRemoteModel != null) {
            try {
                Class<?> clazz = _trackRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_trackRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_trackRemoteModel != null) {
            try {
                Class<?> clazz = _trackRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_trackRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCourseList() {
        return _courseList;
    }

    @Override
    public void setCourseList(String courseList) {
        _courseList = courseList;

        if (_trackRemoteModel != null) {
            try {
                Class<?> clazz = _trackRemoteModel.getClass();

                Method method = clazz.getMethod("setCourseList", String.class);

                method.invoke(_trackRemoteModel, courseList);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAccreditation() {
        return _accreditation;
    }

    @Override
    public void setAccreditation(String accreditation) {
        _accreditation = accreditation;

        if (_trackRemoteModel != null) {
            try {
                Class<?> clazz = _trackRemoteModel.getClass();

                Method method = clazz.getMethod("setAccreditation", String.class);

                method.invoke(_trackRemoteModel, accreditation);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getTrackRemoteModel() {
        return _trackRemoteModel;
    }

    public void setTrackRemoteModel(BaseModel<?> trackRemoteModel) {
        _trackRemoteModel = trackRemoteModel;
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

        Class<?> remoteModelClass = _trackRemoteModel.getClass();

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

        Object returnValue = method.invoke(_trackRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            TrackLocalServiceUtil.addTrack(this);
        } else {
            TrackLocalServiceUtil.updateTrack(this);
        }
    }

    @Override
    public Track toEscapedModel() {
        return (Track) ProxyUtil.newProxyInstance(Track.class.getClassLoader(),
            new Class[] { Track.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        TrackClp clone = new TrackClp();

        clone.setTrackId(getTrackId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setCourseList(getCourseList());
        clone.setAccreditation(getAccreditation());

        return clone;
    }

    @Override
    public int compareTo(Track track) {
        long primaryKey = track.getPrimaryKey();

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

        if (!(obj instanceof TrackClp)) {
            return false;
        }

        TrackClp track = (TrackClp) obj;

        long primaryKey = track.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{trackId=");
        sb.append(getTrackId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", courseList=");
        sb.append(getCourseList());
        sb.append(", accreditation=");
        sb.append(getAccreditation());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("ms3.service.model.Track");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>trackId</column-name><column-value><![CDATA[");
        sb.append(getTrackId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseList</column-name><column-value><![CDATA[");
        sb.append(getCourseList());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>accreditation</column-name><column-value><![CDATA[");
        sb.append(getAccreditation());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
