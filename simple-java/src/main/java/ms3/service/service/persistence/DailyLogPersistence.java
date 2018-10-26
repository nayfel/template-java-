package ms3.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ms3.service.model.DailyLog;

/**
 * The persistence interface for the daily log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jackt
 * @see DailyLogPersistenceImpl
 * @see DailyLogUtil
 * @generated
 */
public interface DailyLogPersistence extends BasePersistence<DailyLog> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DailyLogUtil} to access the daily log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the daily log where dailyLogId = &#63; or throws a {@link ms3.service.NoSuchDailyLogException} if it could not be found.
    *
    * @param dailyLogId the daily log ID
    * @return the matching daily log
    * @throws ms3.service.NoSuchDailyLogException if a matching daily log could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog findBydailyLogId(long dailyLogId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchDailyLogException;

    /**
    * Returns the daily log where dailyLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param dailyLogId the daily log ID
    * @return the matching daily log, or <code>null</code> if a matching daily log could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog fetchBydailyLogId(long dailyLogId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the daily log where dailyLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param dailyLogId the daily log ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching daily log, or <code>null</code> if a matching daily log could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog fetchBydailyLogId(long dailyLogId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the daily log where dailyLogId = &#63; from the database.
    *
    * @param dailyLogId the daily log ID
    * @return the daily log that was removed
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog removeBydailyLogId(long dailyLogId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchDailyLogException;

    /**
    * Returns the number of daily logs where dailyLogId = &#63;.
    *
    * @param dailyLogId the daily log ID
    * @return the number of matching daily logs
    * @throws SystemException if a system exception occurred
    */
    public int countBydailyLogId(long dailyLogId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the daily logs where assignment_id = &#63;.
    *
    * @param assignment_id the assignment_id
    * @return the matching daily logs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ms3.service.model.DailyLog> findByassignment_id(
        long assignment_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the daily logs where assignment_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.DailyLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param assignment_id the assignment_id
    * @param start the lower bound of the range of daily logs
    * @param end the upper bound of the range of daily logs (not inclusive)
    * @return the range of matching daily logs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ms3.service.model.DailyLog> findByassignment_id(
        long assignment_id, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the daily logs where assignment_id = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.DailyLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param assignment_id the assignment_id
    * @param start the lower bound of the range of daily logs
    * @param end the upper bound of the range of daily logs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching daily logs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ms3.service.model.DailyLog> findByassignment_id(
        long assignment_id, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first daily log in the ordered set where assignment_id = &#63;.
    *
    * @param assignment_id the assignment_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching daily log
    * @throws ms3.service.NoSuchDailyLogException if a matching daily log could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog findByassignment_id_First(
        long assignment_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchDailyLogException;

    /**
    * Returns the first daily log in the ordered set where assignment_id = &#63;.
    *
    * @param assignment_id the assignment_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching daily log, or <code>null</code> if a matching daily log could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog fetchByassignment_id_First(
        long assignment_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last daily log in the ordered set where assignment_id = &#63;.
    *
    * @param assignment_id the assignment_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching daily log
    * @throws ms3.service.NoSuchDailyLogException if a matching daily log could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog findByassignment_id_Last(
        long assignment_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchDailyLogException;

    /**
    * Returns the last daily log in the ordered set where assignment_id = &#63;.
    *
    * @param assignment_id the assignment_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching daily log, or <code>null</code> if a matching daily log could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog fetchByassignment_id_Last(
        long assignment_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the daily logs before and after the current daily log in the ordered set where assignment_id = &#63;.
    *
    * @param dailyLogId the primary key of the current daily log
    * @param assignment_id the assignment_id
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next daily log
    * @throws ms3.service.NoSuchDailyLogException if a daily log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog[] findByassignment_id_PrevAndNext(
        long dailyLogId, long assignment_id,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchDailyLogException;

    /**
    * Removes all the daily logs where assignment_id = &#63; from the database.
    *
    * @param assignment_id the assignment_id
    * @throws SystemException if a system exception occurred
    */
    public void removeByassignment_id(long assignment_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of daily logs where assignment_id = &#63;.
    *
    * @param assignment_id the assignment_id
    * @return the number of matching daily logs
    * @throws SystemException if a system exception occurred
    */
    public int countByassignment_id(long assignment_id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the daily log in the entity cache if it is enabled.
    *
    * @param dailyLog the daily log
    */
    public void cacheResult(ms3.service.model.DailyLog dailyLog);

    /**
    * Caches the daily logs in the entity cache if it is enabled.
    *
    * @param dailyLogs the daily logs
    */
    public void cacheResult(
        java.util.List<ms3.service.model.DailyLog> dailyLogs);

    /**
    * Creates a new daily log with the primary key. Does not add the daily log to the database.
    *
    * @param dailyLogId the primary key for the new daily log
    * @return the new daily log
    */
    public ms3.service.model.DailyLog create(long dailyLogId);

    /**
    * Removes the daily log with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param dailyLogId the primary key of the daily log
    * @return the daily log that was removed
    * @throws ms3.service.NoSuchDailyLogException if a daily log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog remove(long dailyLogId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchDailyLogException;

    public ms3.service.model.DailyLog updateImpl(
        ms3.service.model.DailyLog dailyLog)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the daily log with the primary key or throws a {@link ms3.service.NoSuchDailyLogException} if it could not be found.
    *
    * @param dailyLogId the primary key of the daily log
    * @return the daily log
    * @throws ms3.service.NoSuchDailyLogException if a daily log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog findByPrimaryKey(long dailyLogId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchDailyLogException;

    /**
    * Returns the daily log with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param dailyLogId the primary key of the daily log
    * @return the daily log, or <code>null</code> if a daily log with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.DailyLog fetchByPrimaryKey(long dailyLogId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the daily logs.
    *
    * @return the daily logs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ms3.service.model.DailyLog> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ms3.service.model.DailyLog> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the daily logs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.DailyLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of daily logs
    * @param end the upper bound of the range of daily logs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of daily logs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ms3.service.model.DailyLog> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the daily logs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of daily logs.
    *
    * @return the number of daily logs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
