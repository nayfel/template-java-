package ms3.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CourseService}.
 *
 * @author jackt
 * @see CourseService
 * @generated
 */
public class CourseServiceWrapper implements CourseService,
    ServiceWrapper<CourseService> {
    private CourseService _courseService;

    public CourseServiceWrapper(CourseService courseService) {
        _courseService = courseService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _courseService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _courseService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _courseService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CourseService getWrappedCourseService() {
        return _courseService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCourseService(CourseService courseService) {
        _courseService = courseService;
    }

    @Override
    public CourseService getWrappedService() {
        return _courseService;
    }

    @Override
    public void setWrappedService(CourseService courseService) {
        _courseService = courseService;
    }
}
