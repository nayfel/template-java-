package ms3.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ms3.service.service.AssignmentLocalServiceUtil;
import ms3.service.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class AssignmentClp extends BaseModelImpl<Assignment>
    implements Assignment {
    private long _assignmentId;
    private String _courses_title;
    private String _ms3employeedb_uid;
    private String _assignedDate;
    private String _startDate;
    private String _endDate;
    private String _status;
    private String _cost;
    private boolean _certification;
    private double _hoursSpent;
    private String _currentSection;
    private String _notes;
    private String _admin;
    private BaseModel<?> _assignmentRemoteModel;
    private Class<?> _clpSerializerClass = ms3.service.service.ClpSerializer.class;

    public AssignmentClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Assignment.class;
    }

    @Override
    public String getModelClassName() {
        return Assignment.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _assignmentId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setAssignmentId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _assignmentId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("assignmentId", getAssignmentId());
        attributes.put("courses_title", getCourses_title());
        attributes.put("ms3employeedb_uid", getMs3employeedb_uid());
        attributes.put("assignedDate", getAssignedDate());
        attributes.put("startDate", getStartDate());
        attributes.put("endDate", getEndDate());
        attributes.put("status", getStatus());
        attributes.put("cost", getCost());
        attributes.put("certification", getCertification());
        attributes.put("hoursSpent", getHoursSpent());
        attributes.put("currentSection", getCurrentSection());
        attributes.put("notes", getNotes());
        attributes.put("admin", getAdmin());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long assignmentId = (Long) attributes.get("assignmentId");

        if (assignmentId != null) {
            setAssignmentId(assignmentId);
        }

        String courses_title = (String) attributes.get("courses_title");

        if (courses_title != null) {
            setCourses_title(courses_title);
        }

        String ms3employeedb_uid = (String) attributes.get("ms3employeedb_uid");

        if (ms3employeedb_uid != null) {
            setMs3employeedb_uid(ms3employeedb_uid);
        }

        String assignedDate = (String) attributes.get("assignedDate");

        if (assignedDate != null) {
            setAssignedDate(assignedDate);
        }

        String startDate = (String) attributes.get("startDate");

        if (startDate != null) {
            setStartDate(startDate);
        }

        String endDate = (String) attributes.get("endDate");

        if (endDate != null) {
            setEndDate(endDate);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String cost = (String) attributes.get("cost");

        if (cost != null) {
            setCost(cost);
        }

        Boolean certification = (Boolean) attributes.get("certification");

        if (certification != null) {
            setCertification(certification);
        }

        Double hoursSpent = (Double) attributes.get("hoursSpent");

        if (hoursSpent != null) {
            setHoursSpent(hoursSpent);
        }

        String currentSection = (String) attributes.get("currentSection");

        if (currentSection != null) {
            setCurrentSection(currentSection);
        }

        String notes = (String) attributes.get("notes");

        if (notes != null) {
            setNotes(notes);
        }

        String admin = (String) attributes.get("admin");

        if (admin != null) {
            setAdmin(admin);
        }
    }

    @Override
    public long getAssignmentId() {
        return _assignmentId;
    }

    @Override
    public void setAssignmentId(long assignmentId) {
        _assignmentId = assignmentId;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setAssignmentId", long.class);

                method.invoke(_assignmentRemoteModel, assignmentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCourses_title() {
        return _courses_title;
    }

    @Override
    public void setCourses_title(String courses_title) {
        _courses_title = courses_title;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setCourses_title", String.class);

                method.invoke(_assignmentRemoteModel, courses_title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMs3employeedb_uid() {
        return _ms3employeedb_uid;
    }

    @Override
    public void setMs3employeedb_uid(String ms3employeedb_uid) {
        _ms3employeedb_uid = ms3employeedb_uid;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setMs3employeedb_uid",
                        String.class);

                method.invoke(_assignmentRemoteModel, ms3employeedb_uid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAssignedDate() {
        return _assignedDate;
    }

    @Override
    public void setAssignedDate(String assignedDate) {
        _assignedDate = assignedDate;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setAssignedDate", String.class);

                method.invoke(_assignmentRemoteModel, assignedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStartDate() {
        return _startDate;
    }

    @Override
    public void setStartDate(String startDate) {
        _startDate = startDate;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setStartDate", String.class);

                method.invoke(_assignmentRemoteModel, startDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEndDate() {
        return _endDate;
    }

    @Override
    public void setEndDate(String endDate) {
        _endDate = endDate;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setEndDate", String.class);

                method.invoke(_assignmentRemoteModel, endDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatus() {
        return _status;
    }

    @Override
    public void setStatus(String status) {
        _status = status;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", String.class);

                method.invoke(_assignmentRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCost() {
        return _cost;
    }

    @Override
    public void setCost(String cost) {
        _cost = cost;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setCost", String.class);

                method.invoke(_assignmentRemoteModel, cost);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getCertification() {
        return _certification;
    }

    @Override
    public boolean isCertification() {
        return _certification;
    }

    @Override
    public void setCertification(boolean certification) {
        _certification = certification;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setCertification",
                        boolean.class);

                method.invoke(_assignmentRemoteModel, certification);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getHoursSpent() {
        return _hoursSpent;
    }

    @Override
    public void setHoursSpent(double hoursSpent) {
        _hoursSpent = hoursSpent;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setHoursSpent", double.class);

                method.invoke(_assignmentRemoteModel, hoursSpent);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCurrentSection() {
        return _currentSection;
    }

    @Override
    public void setCurrentSection(String currentSection) {
        _currentSection = currentSection;

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setCurrentSection",
                        String.class);

                method.invoke(_assignmentRemoteModel, currentSection);
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

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setNotes", String.class);

                method.invoke(_assignmentRemoteModel, notes);
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

        if (_assignmentRemoteModel != null) {
            try {
                Class<?> clazz = _assignmentRemoteModel.getClass();

                Method method = clazz.getMethod("setAdmin", String.class);

                method.invoke(_assignmentRemoteModel, admin);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getAssignmentRemoteModel() {
        return _assignmentRemoteModel;
    }

    public void setAssignmentRemoteModel(BaseModel<?> assignmentRemoteModel) {
        _assignmentRemoteModel = assignmentRemoteModel;
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

        Class<?> remoteModelClass = _assignmentRemoteModel.getClass();

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

        Object returnValue = method.invoke(_assignmentRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            AssignmentLocalServiceUtil.addAssignment(this);
        } else {
            AssignmentLocalServiceUtil.updateAssignment(this);
        }
    }

    @Override
    public Assignment toEscapedModel() {
        return (Assignment) ProxyUtil.newProxyInstance(Assignment.class.getClassLoader(),
            new Class[] { Assignment.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        AssignmentClp clone = new AssignmentClp();

        clone.setAssignmentId(getAssignmentId());
        clone.setCourses_title(getCourses_title());
        clone.setMs3employeedb_uid(getMs3employeedb_uid());
        clone.setAssignedDate(getAssignedDate());
        clone.setStartDate(getStartDate());
        clone.setEndDate(getEndDate());
        clone.setStatus(getStatus());
        clone.setCost(getCost());
        clone.setCertification(getCertification());
        clone.setHoursSpent(getHoursSpent());
        clone.setCurrentSection(getCurrentSection());
        clone.setNotes(getNotes());
        clone.setAdmin(getAdmin());

        return clone;
    }

    @Override
    public int compareTo(Assignment assignment) {
        long primaryKey = assignment.getPrimaryKey();

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

        if (!(obj instanceof AssignmentClp)) {
            return false;
        }

        AssignmentClp assignment = (AssignmentClp) obj;

        long primaryKey = assignment.getPrimaryKey();

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
        StringBundler sb = new StringBundler(27);

        sb.append("{assignmentId=");
        sb.append(getAssignmentId());
        sb.append(", courses_title=");
        sb.append(getCourses_title());
        sb.append(", ms3employeedb_uid=");
        sb.append(getMs3employeedb_uid());
        sb.append(", assignedDate=");
        sb.append(getAssignedDate());
        sb.append(", startDate=");
        sb.append(getStartDate());
        sb.append(", endDate=");
        sb.append(getEndDate());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", cost=");
        sb.append(getCost());
        sb.append(", certification=");
        sb.append(getCertification());
        sb.append(", hoursSpent=");
        sb.append(getHoursSpent());
        sb.append(", currentSection=");
        sb.append(getCurrentSection());
        sb.append(", notes=");
        sb.append(getNotes());
        sb.append(", admin=");
        sb.append(getAdmin());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(43);

        sb.append("<model><model-name>");
        sb.append("ms3.service.model.Assignment");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>assignmentId</column-name><column-value><![CDATA[");
        sb.append(getAssignmentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courses_title</column-name><column-value><![CDATA[");
        sb.append(getCourses_title());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>ms3employeedb_uid</column-name><column-value><![CDATA[");
        sb.append(getMs3employeedb_uid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>assignedDate</column-name><column-value><![CDATA[");
        sb.append(getAssignedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>startDate</column-name><column-value><![CDATA[");
        sb.append(getStartDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>endDate</column-name><column-value><![CDATA[");
        sb.append(getEndDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cost</column-name><column-value><![CDATA[");
        sb.append(getCost());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>certification</column-name><column-value><![CDATA[");
        sb.append(getCertification());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hoursSpent</column-name><column-value><![CDATA[");
        sb.append(getHoursSpent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>currentSection</column-name><column-value><![CDATA[");
        sb.append(getCurrentSection());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>notes</column-name><column-value><![CDATA[");
        sb.append(getNotes());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>admin</column-name><column-value><![CDATA[");
        sb.append(getAdmin());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
