package ms3.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ms3.service.service.ClpSerializer;
import ms3.service.service.CourseLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class CourseClp extends BaseModelImpl<Course> implements Course {
    private String _title;
    private String _description;
    private String _listPrice;
    private String _provider;
    private long _courseId;
    private double _estimatedHours;
    private String _sections;
    private String _skills;
    private BaseModel<?> _courseRemoteModel;
    private Class<?> _clpSerializerClass = ms3.service.service.ClpSerializer.class;

    public CourseClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Course.class;
    }

    @Override
    public String getModelClassName() {
        return Course.class.getName();
    }

    @Override
    public String getPrimaryKey() {
        return _title;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setTitle(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _title;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("listPrice", getListPrice());
        attributes.put("provider", getProvider());
        attributes.put("courseId", getCourseId());
        attributes.put("estimatedHours", getEstimatedHours());
        attributes.put("sections", getSections());
        attributes.put("skills", getSkills());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String listPrice = (String) attributes.get("listPrice");

        if (listPrice != null) {
            setListPrice(listPrice);
        }

        String provider = (String) attributes.get("provider");

        if (provider != null) {
            setProvider(provider);
        }

        Long courseId = (Long) attributes.get("courseId");

        if (courseId != null) {
            setCourseId(courseId);
        }

        Double estimatedHours = (Double) attributes.get("estimatedHours");

        if (estimatedHours != null) {
            setEstimatedHours(estimatedHours);
        }

        String sections = (String) attributes.get("sections");

        if (sections != null) {
            setSections(sections);
        }

        String skills = (String) attributes.get("skills");

        if (skills != null) {
            setSkills(skills);
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_courseRemoteModel != null) {
            try {
                Class<?> clazz = _courseRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_courseRemoteModel, title);
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

        if (_courseRemoteModel != null) {
            try {
                Class<?> clazz = _courseRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_courseRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getListPrice() {
        return _listPrice;
    }

    @Override
    public void setListPrice(String listPrice) {
        _listPrice = listPrice;

        if (_courseRemoteModel != null) {
            try {
                Class<?> clazz = _courseRemoteModel.getClass();

                Method method = clazz.getMethod("setListPrice", String.class);

                method.invoke(_courseRemoteModel, listPrice);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProvider() {
        return _provider;
    }

    @Override
    public void setProvider(String provider) {
        _provider = provider;

        if (_courseRemoteModel != null) {
            try {
                Class<?> clazz = _courseRemoteModel.getClass();

                Method method = clazz.getMethod("setProvider", String.class);

                method.invoke(_courseRemoteModel, provider);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCourseId() {
        return _courseId;
    }

    @Override
    public void setCourseId(long courseId) {
        _courseId = courseId;

        if (_courseRemoteModel != null) {
            try {
                Class<?> clazz = _courseRemoteModel.getClass();

                Method method = clazz.getMethod("setCourseId", long.class);

                method.invoke(_courseRemoteModel, courseId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getEstimatedHours() {
        return _estimatedHours;
    }

    @Override
    public void setEstimatedHours(double estimatedHours) {
        _estimatedHours = estimatedHours;

        if (_courseRemoteModel != null) {
            try {
                Class<?> clazz = _courseRemoteModel.getClass();

                Method method = clazz.getMethod("setEstimatedHours",
                        double.class);

                method.invoke(_courseRemoteModel, estimatedHours);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSections() {
        return _sections;
    }

    @Override
    public void setSections(String sections) {
        _sections = sections;

        if (_courseRemoteModel != null) {
            try {
                Class<?> clazz = _courseRemoteModel.getClass();

                Method method = clazz.getMethod("setSections", String.class);

                method.invoke(_courseRemoteModel, sections);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSkills() {
        return _skills;
    }

    @Override
    public void setSkills(String skills) {
        _skills = skills;

        if (_courseRemoteModel != null) {
            try {
                Class<?> clazz = _courseRemoteModel.getClass();

                Method method = clazz.getMethod("setSkills", String.class);

                method.invoke(_courseRemoteModel, skills);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getCourseRemoteModel() {
        return _courseRemoteModel;
    }

    public void setCourseRemoteModel(BaseModel<?> courseRemoteModel) {
        _courseRemoteModel = courseRemoteModel;
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

        Class<?> remoteModelClass = _courseRemoteModel.getClass();

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

        Object returnValue = method.invoke(_courseRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CourseLocalServiceUtil.addCourse(this);
        } else {
            CourseLocalServiceUtil.updateCourse(this);
        }
    }

    @Override
    public Course toEscapedModel() {
        return (Course) ProxyUtil.newProxyInstance(Course.class.getClassLoader(),
            new Class[] { Course.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CourseClp clone = new CourseClp();

        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setListPrice(getListPrice());
        clone.setProvider(getProvider());
        clone.setCourseId(getCourseId());
        clone.setEstimatedHours(getEstimatedHours());
        clone.setSections(getSections());
        clone.setSkills(getSkills());

        return clone;
    }

    @Override
    public int compareTo(Course course) {
        String primaryKey = course.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CourseClp)) {
            return false;
        }

        CourseClp course = (CourseClp) obj;

        String primaryKey = course.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
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
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(17);

        sb.append("{title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", listPrice=");
        sb.append(getListPrice());
        sb.append(", provider=");
        sb.append(getProvider());
        sb.append(", courseId=");
        sb.append(getCourseId());
        sb.append(", estimatedHours=");
        sb.append(getEstimatedHours());
        sb.append(", sections=");
        sb.append(getSections());
        sb.append(", skills=");
        sb.append(getSkills());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(28);

        sb.append("<model><model-name>");
        sb.append("ms3.service.model.Course");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>listPrice</column-name><column-value><![CDATA[");
        sb.append(getListPrice());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>provider</column-name><column-value><![CDATA[");
        sb.append(getProvider());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>courseId</column-name><column-value><![CDATA[");
        sb.append(getCourseId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>estimatedHours</column-name><column-value><![CDATA[");
        sb.append(getEstimatedHours());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sections</column-name><column-value><![CDATA[");
        sb.append(getSections());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>skills</column-name><column-value><![CDATA[");
        sb.append(getSkills());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
