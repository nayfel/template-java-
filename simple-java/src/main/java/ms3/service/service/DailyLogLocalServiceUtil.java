package ms3.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DailyLog. This utility wraps
 * {@link ms3.service.service.impl.DailyLogLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author jackt
 * @see DailyLogLocalService
 * @see ms3.service.service.base.DailyLogLocalServiceBaseImpl
 * @see ms3.service.service.impl.DailyLogLocalServiceImpl
 * @generated
 */
public class DailyLogLocalServiceUtil {
    private static DailyLogLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link ms3.service.service.impl.DailyLogLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the daily log to the database. Also notifies the appropriate model listeners.
    *
    * @param dailyLog the daily log
    * @return the daily log that was added
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.DailyLog addDailyLog(
        ms3.service.model.DailyLog dailyLog)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addDailyLog(dailyLog);
    }

    /**
    * Creates a new daily log with the primary key. Does not add the daily log to the database.
    *
    * @param dailyLogId the primary key for the new daily log
    * @return the new daily log
    */
    public static ms3.service.model.DailyLog createDailyLog(long dailyLogId) {
        return getService().createDailyLog(dailyLogId);
    }

    /**
    * Deletes the daily log with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dailyLogId the primary key of the daily log
    * @return the daily log that was removed
    * @throws PortalException if a daily log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.DailyLog deleteDailyLog(long dailyLogId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDailyLog(dailyLogId);
    }

    /**
    * Deletes the daily log from the database. Also notifies the appropriate model listeners.
    *
    * @param dailyLog the daily log
    * @return the daily log that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.DailyLog deleteDailyLog(
        ms3.service.model.DailyLog dailyLog)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDailyLog(dailyLog);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.DailyLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.DailyLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static ms3.service.model.DailyLog fetchDailyLog(long dailyLogId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchDailyLog(dailyLogId);
    }

    /**
    * Returns the daily log with the primary key.
    *
    * @param dailyLogId the primary key of the daily log
    * @return the daily log
    * @throws PortalException if a daily log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.DailyLog getDailyLog(long dailyLogId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDailyLog(dailyLogId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the daily logs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.DailyLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of daily logs
    * @param end the upper bound of the range of daily logs (not inclusive)
    * @return the range of daily logs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ms3.service.model.DailyLog> getDailyLogs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDailyLogs(start, end);
    }

    /**
    * Returns the number of daily logs.
    *
    * @return the number of daily logs
    * @throws SystemException if a system exception occurred
    */
    public static int getDailyLogsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDailyLogsCount();
    }

    /**
    * Updates the daily log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dailyLog the daily log
    * @return the daily log that was updated
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.DailyLog updateDailyLog(
        ms3.service.model.DailyLog dailyLog)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateDailyLog(dailyLog);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static DailyLogLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DailyLogLocalService.class.getName());

            if (invokableLocalService instanceof DailyLogLocalService) {
                _service = (DailyLogLocalService) invokableLocalService;
            } else {
                _service = new DailyLogLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(DailyLogLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DailyLogLocalService service) {
    }
}
