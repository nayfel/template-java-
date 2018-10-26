package ms3.service.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import ms3.service.model.Course;

import ms3.service.service.CourseLocalServiceUtil;

/**
 * The extended model base implementation for the Course service. Represents a row in the &quot;train_Course&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CourseImpl}.
 * </p>
 *
 * @author jackt
 * @see CourseImpl
 * @see ms3.service.model.Course
 * @generated
 */
public abstract class CourseBaseImpl extends CourseModelImpl implements Course {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a course model instance should use the {@link Course} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CourseLocalServiceUtil.addCourse(this);
        } else {
            CourseLocalServiceUtil.updateCourse(this);
        }
    }
}
