package ms3.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssignmentService}.
 *
 * @author jackt
 * @see AssignmentService
 * @generated
 */
public class AssignmentServiceWrapper implements AssignmentService,
    ServiceWrapper<AssignmentService> {
    private AssignmentService _assignmentService;

    public AssignmentServiceWrapper(AssignmentService assignmentService) {
        _assignmentService = assignmentService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _assignmentService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _assignmentService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _assignmentService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public AssignmentService getWrappedAssignmentService() {
        return _assignmentService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedAssignmentService(AssignmentService assignmentService) {
        _assignmentService = assignmentService;
    }

    @Override
    public AssignmentService getWrappedService() {
        return _assignmentService;
    }

    @Override
    public void setWrappedService(AssignmentService assignmentService) {
        _assignmentService = assignmentService;
    }
}
