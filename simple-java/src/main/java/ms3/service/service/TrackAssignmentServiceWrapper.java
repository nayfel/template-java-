package ms3.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrackAssignmentService}.
 *
 * @author jackt
 * @see TrackAssignmentService
 * @generated
 */
public class TrackAssignmentServiceWrapper implements TrackAssignmentService,
    ServiceWrapper<TrackAssignmentService> {
    private TrackAssignmentService _trackAssignmentService;

    public TrackAssignmentServiceWrapper(
        TrackAssignmentService trackAssignmentService) {
        _trackAssignmentService = trackAssignmentService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _trackAssignmentService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _trackAssignmentService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _trackAssignmentService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TrackAssignmentService getWrappedTrackAssignmentService() {
        return _trackAssignmentService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTrackAssignmentService(
        TrackAssignmentService trackAssignmentService) {
        _trackAssignmentService = trackAssignmentService;
    }

    @Override
    public TrackAssignmentService getWrappedService() {
        return _trackAssignmentService;
    }

    @Override
    public void setWrappedService(TrackAssignmentService trackAssignmentService) {
        _trackAssignmentService = trackAssignmentService;
    }
}
