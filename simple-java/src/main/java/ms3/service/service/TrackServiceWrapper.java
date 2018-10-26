package ms3.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrackService}.
 *
 * @author jackt
 * @see TrackService
 * @generated
 */
public class TrackServiceWrapper implements TrackService,
    ServiceWrapper<TrackService> {
    private TrackService _trackService;

    public TrackServiceWrapper(TrackService trackService) {
        _trackService = trackService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _trackService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _trackService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _trackService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TrackService getWrappedTrackService() {
        return _trackService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTrackService(TrackService trackService) {
        _trackService = trackService;
    }

    @Override
    public TrackService getWrappedService() {
        return _trackService;
    }

    @Override
    public void setWrappedService(TrackService trackService) {
        _trackService = trackService;
    }
}
