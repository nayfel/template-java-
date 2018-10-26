package ms3.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Assignment service. Represents a row in the &quot;train_Assignment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ms3.service.model.impl.AssignmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ms3.service.model.impl.AssignmentImpl}.
 * </p>
 *
 * @author jackt
 * @see Assignment
 * @see ms3.service.model.impl.AssignmentImpl
 * @see ms3.service.model.impl.AssignmentModelImpl
 * @generated
 */
public interface AssignmentModel extends BaseModel<Assignment> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a assignment model instance should use the {@link Assignment} interface instead.
     */

    /**
     * Returns the primary key of this assignment.
     *
     * @return the primary key of this assignment
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this assignment.
     *
     * @param primaryKey the primary key of this assignment
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the assignment ID of this assignment.
     *
     * @return the assignment ID of this assignment
     */
    public long getAssignmentId();

    /**
     * Sets the assignment ID of this assignment.
     *
     * @param assignmentId the assignment ID of this assignment
     */
    public void setAssignmentId(long assignmentId);

    /**
     * Returns the courses_title of this assignment.
     *
     * @return the courses_title of this assignment
     */
    @AutoEscape
    public String getCourses_title();

    /**
     * Sets the courses_title of this assignment.
     *
     * @param courses_title the courses_title of this assignment
     */
    public void setCourses_title(String courses_title);

    /**
     * Returns the ms3employeedb_uid of this assignment.
     *
     * @return the ms3employeedb_uid of this assignment
     */
    @AutoEscape
    public String getMs3employeedb_uid();

    /**
     * Sets the ms3employeedb_uid of this assignment.
     *
     * @param ms3employeedb_uid the ms3employeedb_uid of this assignment
     */
    public void setMs3employeedb_uid(String ms3employeedb_uid);

    /**
     * Returns the assigned date of this assignment.
     *
     * @return the assigned date of this assignment
     */
    @AutoEscape
    public String getAssignedDate();

    /**
     * Sets the assigned date of this assignment.
     *
     * @param assignedDate the assigned date of this assignment
     */
    public void setAssignedDate(String assignedDate);

    /**
     * Returns the start date of this assignment.
     *
     * @return the start date of this assignment
     */
    @AutoEscape
    public String getStartDate();

    /**
     * Sets the start date of this assignment.
     *
     * @param startDate the start date of this assignment
     */
    public void setStartDate(String startDate);

    /**
     * Returns the end date of this assignment.
     *
     * @return the end date of this assignment
     */
    @AutoEscape
    public String getEndDate();

    /**
     * Sets the end date of this assignment.
     *
     * @param endDate the end date of this assignment
     */
    public void setEndDate(String endDate);

    /**
     * Returns the status of this assignment.
     *
     * @return the status of this assignment
     */
    @AutoEscape
    public String getStatus();

    /**
     * Sets the status of this assignment.
     *
     * @param status the status of this assignment
     */
    public void setStatus(String status);

    /**
     * Returns the cost of this assignment.
     *
     * @return the cost of this assignment
     */
    @AutoEscape
    public String getCost();

    /**
     * Sets the cost of this assignment.
     *
     * @param cost the cost of this assignment
     */
    public void setCost(String cost);

    /**
     * Returns the certification of this assignment.
     *
     * @return the certification of this assignment
     */
    public boolean getCertification();

    /**
     * Returns <code>true</code> if this assignment is certification.
     *
     * @return <code>true</code> if this assignment is certification; <code>false</code> otherwise
     */
    public boolean isCertification();

    /**
     * Sets whether this assignment is certification.
     *
     * @param certification the certification of this assignment
     */
    public void setCertification(boolean certification);

    /**
     * Returns the hours spent of this assignment.
     *
     * @return the hours spent of this assignment
     */
    public double getHoursSpent();

    /**
     * Sets the hours spent of this assignment.
     *
     * @param hoursSpent the hours spent of this assignment
     */
    public void setHoursSpent(double hoursSpent);

    /**
     * Returns the current section of this assignment.
     *
     * @return the current section of this assignment
     */
    @AutoEscape
    public String getCurrentSection();

    /**
     * Sets the current section of this assignment.
     *
     * @param currentSection the current section of this assignment
     */
    public void setCurrentSection(String currentSection);

    /**
     * Returns the notes of this assignment.
     *
     * @return the notes of this assignment
     */
    @AutoEscape
    public String getNotes();

    /**
     * Sets the notes of this assignment.
     *
     * @param notes the notes of this assignment
     */
    public void setNotes(String notes);

    /**
     * Returns the admin of this assignment.
     *
     * @return the admin of this assignment
     */
    @AutoEscape
    public String getAdmin();

    /**
     * Sets the admin of this assignment.
     *
     * @param admin the admin of this assignment
     */
    public void setAdmin(String admin);

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
    public int compareTo(ms3.service.model.Assignment assignment);

    @Override
    public int hashCode();

    @Override
    public CacheModel<ms3.service.model.Assignment> toCacheModel();

    @Override
    public ms3.service.model.Assignment toEscapedModel();

    @Override
    public ms3.service.model.Assignment toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
