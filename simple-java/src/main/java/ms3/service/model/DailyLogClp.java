package ms3.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ms3.service.service.ClpSerializer;
import ms3.service.service.DailyLogLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class DailyLogClp extends BaseModelImpl<DailyLog> implements DailyLog {
    private long _dailyLogId;
    private long _assignment_id;
    private String _date;
    private String _accomplishments;
    private String _roadblocks;
    private String _plan;
    private String _notes;
    private double _hours;
    private String _section;
    private BaseModel<?> _dailyLogRemoteModel;
    private Class<?> _clpSerializerClass = ms3.service.service.ClpSerializer.class;

    public DailyLogClp() {
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
    public long getPrimaryKey() {
        return _dailyLogId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setDailyLogId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _dailyLogId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getDailyLogId() {
        return _dailyLogId;
    }

    @Override
    public void setDailyLogId(long dailyLogId) {
        _dailyLogId = dailyLogId;

        if (_dailyLogRemoteModel != null) {
            try {
                Class<?> clazz = _dailyLogRemoteModel.getClass();

                Method method = clazz.getMethod("setDailyLogId", long.class);

                method.invoke(_dailyLogRemoteModel, dailyLogId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAssignment_id() {
        return _assignment_id;
    }

    @Override
    public void setAssignment_id(long assignment_id) {
        _assignment_id = assignment_id;

        if (_dailyLogRemoteModel != null) {
            try {
                Class<?> clazz = _dailyLogRemoteModel.getClass();

                Method method = clazz.getMethod("setAssignment_id", long.class);

                method.invoke(_dailyLogRemoteModel, assignment_id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDate() {
        return _date;
    }

    @Override
    public void setDate(String date) {
        _date = date;

        if (_dailyLogRemoteModel != null) {
            try {
                Class<?> clazz = _dailyLogRemoteModel.getClass();

                Method method = clazz.getMethod("setDate", String.class);

                method.invoke(_dailyLogRemoteModel, date);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAccomplishments() {
        return _accomplishments;
    }

    @Override
    public void setAccomplishments(String accomplishments) {
        _accomplishments = accomplishments;

        if (_dailyLogRemoteModel != null) {
            try {
                Class<?> clazz = _dailyLogRemoteModel.getClass();

                Method method = clazz.getMethod("setAccomplishments",
                        String.class);

                method.invoke(_dailyLogRemoteModel, accomplishments);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRoadblocks() {
        return _roadblocks;
    }

    @Override
    public void setRoadblocks(String roadblocks) {
        _roadblocks = roadblocks;

        if (_dailyLogRemoteModel != null) {
            try {
                Class<?> clazz = _dailyLogRemoteModel.getClass();

                Method method = clazz.getMethod("setRoadblocks", String.class);

                method.invoke(_dailyLogRemoteModel, roadblocks);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPlan() {
        return _plan;
    }

    @Override
    public void setPlan(String plan) {
        _plan = plan;

        if (_dailyLogRemoteModel != null) {
            try {
                Class<?> clazz = _dailyLogRemoteModel.getClass();

                Method method = clazz.getMethod("setPlan", String.class);

                method.invoke(_dailyLogRemoteModel, plan);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNotes() {
        return _notes;
    }

    @Override
    public void setNotes(String notes) {
        _notes = notes;

        if (_dailyLogRemoteModel != null) {
            try {
                Class<?> clazz = _dailyLogRemoteModel.getClass();

                Method method = clazz.getMethod("setNotes", String.class);

                method.invoke(_dailyLogRemoteModel, notes);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getHours() {
        return _hours;
    }

    @Override
    public void setHours(double hours) {
        _hours = hours;

        if (_dailyLogRemoteModel != null) {
            try {
                Class<?> clazz = _dailyLogRemoteModel.getClass();

                Method method = clazz.getMethod("setHours", double.class);

                method.invoke(_dailyLogRemoteModel, hours);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSection() {
        return _section;
    }

    @Override
    public void setSection(String section) {
        _section = section;

        if (_dailyLogRemoteModel != null) {
            try {
                Class<?> clazz = _dailyLogRemoteModel.getClass();

                Method method = clazz.getMethod("setSection", String.class);

                method.invoke(_dailyLogRemoteModel, section);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getDailyLogRemoteModel() {
        return _dailyLogRemoteModel;
    }

    public void setDailyLogRemoteModel(BaseModel<?> dailyLogRemoteModel) {
        _dailyLogRemoteModel = dailyLogRemoteModel;
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

        Class<?> remoteModelClass = _dailyLogRemoteModel.getClass();

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

        Object returnValue = method.invoke(_dailyLogRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DailyLogLocalServiceUtil.addDailyLog(this);
        } else {
            DailyLogLocalServiceUtil.updateDailyLog(this);
        }
    }

    @Override
    public DailyLog toEscapedModel() {
        return (DailyLog) ProxyUtil.newProxyInstance(DailyLog.class.getClassLoader(),
            new Class[] { DailyLog.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        DailyLogClp clone = new DailyLogClp();

        clone.setDailyLogId(getDailyLogId());
        clone.setAssignment_id(getAssignment_id());
        clone.setDate(getDate());
        clone.setAccomplishments(getAccomplishments());
        clone.setRoadblocks(getRoadblocks());
        clone.setPlan(getPlan());
        clone.setNotes(getNotes());
        clone.setHours(getHours());
        clone.setSection(getSection());

        return clone;
    }

    @Override
    public int compareTo(DailyLog dailyLog) {
        long primaryKey = dailyLog.getPrimaryKey();

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

        if (!(obj instanceof DailyLogClp)) {
            return false;
        }

        DailyLogClp dailyLog = (DailyLogClp) obj;

        long primaryKey = dailyLog.getPrimaryKey();

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
        StringBundler sb = new StringBundler(19);

        sb.append("{dailyLogId=");
        sb.append(getDailyLogId());
        sb.append(", assignment_id=");
        sb.append(getAssignment_id());
        sb.append(", date=");
        sb.append(getDate());
        sb.append(", accomplishments=");
        sb.append(getAccomplishments());
        sb.append(", roadblocks=");
        sb.append(getRoadblocks());
        sb.append(", plan=");
        sb.append(getPlan());
        sb.append(", notes=");
        sb.append(getNotes());
        sb.append(", hours=");
        sb.append(getHours());
        sb.append(", section=");
        sb.append(getSection());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("ms3.service.model.DailyLog");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>dailyLogId</column-name><column-value><![CDATA[");
        sb.append(getDailyLogId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>assignment_id</column-name><column-value><![CDATA[");
        sb.append(getAssignment_id());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>date</column-name><column-value><![CDATA[");
        sb.append(getDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>accomplishments</column-name><column-value><![CDATA[");
        sb.append(getAccomplishments());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>roadblocks</column-name><column-value><![CDATA[");
        sb.append(getRoadblocks());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>plan</column-name><column-value><![CDATA[");
        sb.append(getPlan());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>notes</column-name><column-value><![CDATA[");
        sb.append(getNotes());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hours</column-name><column-value><![CDATA[");
        sb.append(getHours());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>section</column-name><column-value><![CDATA[");
        sb.append(getSection());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
