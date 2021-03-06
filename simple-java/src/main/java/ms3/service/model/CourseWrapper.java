package ms3.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Course}.
 * </p>
 *
 * @author jackt
 * @see Course
 * @generated
 */
public class CourseWrapper implements Course, ModelWrapper<Course> {
    private Course _course;

    public CourseWrapper(Course course) {
        _course = course;
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

    /**
    * Returns the primary key of this course.
    *
    * @return the primary key of this course
    */
    @Override
    public java.lang.String getPrimaryKey() {
        return _course.getPrimaryKey();
    }

    /**
    * Sets the primary key of this course.
    *
    * @param primaryKey the primary key of this course
    */
    @Override
    public void setPrimaryKey(java.lang.String primaryKey) {
        _course.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the title of this course.
    *
    * @return the title of this course
    */
    @Override
    public java.lang.String getTitle() {
        return _course.getTitle();
    }

    /**
    * Sets the title of this course.
    *
    * @param title the title of this course
    */
    @Override
    public void setTitle(java.lang.String title) {
        _course.setTitle(title);
    }

    /**
    * Returns the description of this course.
    *
    * @return the description of this course
    */
    @Override
    public java.lang.String getDescription() {
        return _course.getDescription();
    }

    /**
    * Sets the description of this course.
    *
    * @param description the description of this course
    */
    @Override
    public void setDescription(java.lang.String description) {
        _course.setDescription(description);
    }

    /**
    * Returns the list price of this course.
    *
    * @return the list price of this course
    */
    @Override
    public java.lang.String getListPrice() {
        return _course.getListPrice();
    }

    /**
    * Sets the list price of this course.
    *
    * @param listPrice the list price of this course
    */
    @Override
    public void setListPrice(java.lang.String listPrice) {
        _course.setListPrice(listPrice);
    }

    /**
    * Returns the provider of this course.
    *
    * @return the provider of this course
    */
    @Override
    public java.lang.String getProvider() {
        return _course.getProvider();
    }

    /**
    * Sets the provider of this course.
    *
    * @param provider the provider of this course
    */
    @Override
    public void setProvider(java.lang.String provider) {
        _course.setProvider(provider);
    }

    /**
    * Returns the course ID of this course.
    *
    * @return the course ID of this course
    */
    @Override
    public long getCourseId() {
        return _course.getCourseId();
    }

    /**
    * Sets the course ID of this course.
    *
    * @param courseId the course ID of this course
    */
    @Override
    public void setCourseId(long courseId) {
        _course.setCourseId(courseId);
    }

    /**
    * Returns the estimated hours of this course.
    *
    * @return the estimated hours of this course
    */
    @Override
    public double getEstimatedHours() {
        return _course.getEstimatedHours();
    }

    /**
    * Sets the estimated hours of this course.
    *
    * @param estimatedHours the estimated hours of this course
    */
    @Override
    public void setEstimatedHours(double estimatedHours) {
        _course.setEstimatedHours(estimatedHours);
    }

    /**
    * Returns the sections of this course.
    *
    * @return the sections of this course
    */
    @Override
    public java.lang.String getSections() {
        return _course.getSections();
    }

    /**
    * Sets the sections of this course.
    *
    * @param sections the sections of this course
    */
    @Override
    public void setSections(java.lang.String sections) {
        _course.setSections(sections);
    }

    /**
    * Returns the skills of this course.
    *
    * @return the skills of this course
    */
    @Override
    public java.lang.String getSkills() {
        return _course.getSkills();
    }

    /**
    * Sets the skills of this course.
    *
    * @param skills the skills of this course
    */
    @Override
    public void setSkills(java.lang.String skills) {
        _course.setSkills(skills);
    }

    @Override
    public boolean isNew() {
        return _course.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _course.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _course.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _course.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _course.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _course.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _course.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _course.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _course.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _course.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _course.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CourseWrapper((Course) _course.clone());
    }

    @Override
    public int compareTo(ms3.service.model.Course course) {
        return _course.compareTo(course);
    }

    @Override
    public int hashCode() {
        return _course.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ms3.service.model.Course> toCacheModel() {
        return _course.toCacheModel();
    }

    @Override
    public ms3.service.model.Course toEscapedModel() {
        return new CourseWrapper(_course.toEscapedModel());
    }

    @Override
    public ms3.service.model.Course toUnescapedModel() {
        return new CourseWrapper(_course.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _course.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _course.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _course.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CourseWrapper)) {
            return false;
        }

        CourseWrapper courseWrapper = (CourseWrapper) obj;

        if (Validator.equals(_course, courseWrapper._course)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Course getWrappedCourse() {
        return _course;
    }

    @Override
    public Course getWrappedModel() {
        return _course;
    }

    @Override
    public void resetOriginalValues() {
        _course.resetOriginalValues();
    }
}
