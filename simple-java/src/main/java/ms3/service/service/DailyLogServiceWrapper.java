package ms3.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DailyLogService}.
 *
 * @author jackt
 * @see DailyLogService
 * @generated
 */
public class DailyLogServiceWrapper implements DailyLogService,
    ServiceWrapper<DailyLogService> {
    private DailyLogService _dailyLogService;

    public DailyLogServiceWrapper(DailyLogService dailyLogService) {
        _dailyLogService = dailyLogService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _dailyLogService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _dailyLogService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _dailyLogService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public DailyLogService getWrappedDailyLogService() {
        return _dailyLogService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedDailyLogService(DailyLogService dailyLogService) {
        _dailyLogService = dailyLogService;
    }

    @Override
    public DailyLogService getWrappedService() {
        return _dailyLogService;
    }

    @Override
    public void setWrappedService(DailyLogService dailyLogService) {
        _dailyLogService = dailyLogService;
    }
}
