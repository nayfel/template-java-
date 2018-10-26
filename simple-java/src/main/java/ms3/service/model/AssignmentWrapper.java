package ms3.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Assignment}.
 * </p>
 *
 * @author jackt
 * @see Assignment
 * @generated
 */
public class AssignmentWrapper implements Assignment, ModelWrapper<Assignment> {
    private Assignment _assignment;

    public AssignmentWrapper(Assignment assignment) {
        _assignment = assignment;
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

    /**
    * Returns the primary key of this assignment.
    *
    * @return the primary key of this assignment
    */
    @Override
    public long getPrimaryKey() {
        return _assignment.getPrimaryKey();
    }

    /**
    * Sets the primary key of this assignment.
    *
    * @param primaryKey the primary key of this assignment
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _assignment.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the assignment ID of this assignment.
    *
    * @return the assignment ID of this assignment
    */
    @Override
    public long getAssignmentId() {
        return _assignment.getAssignmentId();
    }

    /**
    * Sets the assignment ID of this assignment.
    *
    * @param assignmentId the assignment ID of this assignment
    */
    @Override
    public void setAssignmentId(long assignmentId) {
        _assignment.setAssignmentId(assignmentId);
    }

    /**
    * Returns the courses_title of this assignment.
    *
    * @return the courses_title of this assignment
    */
    @Override
    public java.lang.String getCourses_title() {
        return _assignment.getCourses_title();
    }

    /**
    * Sets the courses_title of this assignment.
    *
    * @param courses_title the courses_title of this assignment
    */
    @Override
    public void setCourses_title(java.lang.String courses_title) {
        _assignment.setCourses_title(courses_title);
    }

    /**
    * Returns the ms3employeedb_uid of this assignment.
    *
    * @return the ms3employeedb_uid of this assignment
    */
    @Override
    public java.lang.String getMs3employeedb_uid() {
        return _assignment.getMs3employeedb_uid();
    }

    /**
    * Sets the ms3employeedb_uid of this assignment.
    *
    * @param ms3employeedb_uid the ms3employeedb_uid of this assignment
    */
    @Override
    public void setMs3employeedb_uid(java.lang.String ms3employeedb_uid) {
        _assignment.setMs3employeedb_uid(ms3employeedb_uid);
    }

    /**
    * Returns the assigned date of this assignment.
    *
    * @return the assigned date of this assignment
    */
    @Override
    public java.lang.String getAssignedDate() {
        return _assignment.getAssignedDate();
    }

    /**
    * Sets the assigned date of this assignment.
    *
    * @param assignedDate the assigned date of this assignment
    */
    @Override
    public void setAssignedDate(java.lang.String assignedDate) {
        _assignment.setAssignedDate(assignedDate);
    }

    /**
    * Returns the start date of this assignment.
    *
    * @return the start date of this assignment
    */
    @Override
    public java.lang.String getStartDate() {
        return _assignment.getStartDate();
    }

    /**
    * Sets the start date of this assignment.
    *
    * @param startDate the start date of this assignment
    */
    @Override
    public void setStartDate(java.lang.String startDate) {
        _assignment.setStartDate(startDate);
    }

    /**
    * Returns the end date of this assignment.
    *
    * @return the end date of this assignment
    */
    @Override
    public java.lang.String getEndDate() {
        return _assignment.getEndDate();
    }

    /**
    * Sets the end date of this assignment.
    *
    * @param endDate the end date of this assignment
    */
    @Override
    public void setEndDate(java.lang.String endDate) {
        _assignment.setEndDate(endDate);
    }

    /**
    * Returns the status of this assignment.
    *
    * @return the status of this assignment
    */
    @Override
    public java.lang.String getStatus() {
        return _assignment.getStatus();
    }

    /**
    * Sets the status of this assignment.
    *
    * @param status the status of this assignment
    */
    @Override
    public void setStatus(java.lang.String status) {
        _assignment.setStatus(status);
    }

    /**
    * Returns the cost of this assignment.
    *
    * @return the cost of this assignment
    */
    @Override
    public java.lang.String getCost() {
        return _assignment.getCost();
    }

    /**
    * Sets the cost of this assignment.
    *
    * @param cost the cost of this assignment
    */
    @Override
    public void setCost(java.lang.String cost) {
        _assignment.setCost(cost);
    }

    /**
    * Returns the certification of this assignment.
    *
    * @return the certification of this assignment
    */
    @Override
    public boolean getCertification() {
        return _assignment.getCertification();
    }

    /**
    * Returns <code>true</code> if this assignment is certification.
    *
    * @return <code>true</code> if this assignment is certification; <code>false</code> otherwise
    */
    @Override
    public boolean isCertification() {
        return _assignment.isCertification();
    }

    /**
    * Sets whether this assignment is certification.
    *
    * @param certification the certification of this assignment
    */
    @Override
    public void setCertification(boolean certification) {
        _assignment.setCertification(certification);
    }

    /**
    * Returns the hours spent of this assignment.
    *
    * @return the hours spent of this assignment
    */
    @Override
    public double getHoursSpent() {
        return _assignment.getHoursSpent();
    }

    /**
    * Sets the hours spent of this assignment.
    *
    * @param hoursSpent the hours spent of this assignment
    */
    @Override
    public void setHoursSpent(double hoursSpent) {
        _assignment.setHoursSpent(hoursSpent);
    }

    /**
    * Returns the current section of this assignment.
    *
    * @return the current section of this assignment
    */
    @Override
    public java.lang.String getCurrentSection() {
        return _assignment.getCurrentSection();
    }

    /**
    * Sets the current section of this assignment.
    *
    * @param currentSection the current section of this assignment
    */
    @Override
    public void setCurrentSection(java.lang.String currentSection) {
        _assignment.setCurrentSection(currentSection);
    }

    /**
    * Returns the notes of this assignment.
    *
    * @return the notes of this assignment
    */
    @Override
    public java.lang.String getNotes() {
        return _assignment.getNotes();
    }

    /**
    * Sets the notes of this assignment.
    *
    * @param notes the notes of this assignment
    */
    @Override
    public void setNotes(java.lang.String notes) {
        _assignment.setNotes(notes);
    }

    /**
    * Returns the admin of this assignment.
    *
    * @return the admin of this assignment
    */
    @Override
    public java.lang.String getAdmin() {
        return _assignment.getAdmin();
    }

    /**
    * Sets the admin of this assignment.
    *
    * @param admin the admin of this assignment
    */
    @Override
    public void setAdmin(java.lang.String admin) {
        _assignment.setAdmin(admin);
    }

    @Override
    public boolean isNew() {
        return _assignment.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _assignment.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _assignment.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _assignment.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _assignment.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _assignment.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _assignment.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _assignment.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _assignment.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _assignment.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _assignment.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AssignmentWrapper((Assignment) _assignment.clone());
    }

    @Override
    public int compareTo(ms3.service.model.Assignment assignment) {
        return _assignment.compareTo(assignment);
    }

    @Override
    public int hashCode() {
        return _assignment.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<ms3.service.model.Assignment> toCacheModel() {
        return _assignment.toCacheModel();
    }

    @Override
    public ms3.service.model.Assignment toEscapedModel() {
        return new AssignmentWrapper(_assignment.toEscapedModel());
    }

    @Override
    public ms3.service.model.Assignment toUnescapedModel() {
        return new AssignmentWrapper(_assignment.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _assignment.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _assignment.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _assignment.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AssignmentWrapper)) {
            return false;
        }

        AssignmentWrapper assignmentWrapper = (AssignmentWrapper) obj;

        if (Validator.equals(_assignment, assignmentWrapper._assignment)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Assignment getWrappedAssignment() {
        return _assignment;
    }

    @Override
    public Assignment getWrappedModel() {
        return _assignment;
    }

    @Override
    public void resetOriginalValues() {
        _assignment.resetOriginalValues();
    }
}
