package ms3.service.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ms3.service.NoSuchDailyLogException;

import ms3.service.model.DailyLog;
import ms3.service.model.impl.DailyLogImpl;
import ms3.service.model.impl.DailyLogModelImpl;

import ms3.service.service.persistence.DailyLogPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the daily log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jackt
 * @see DailyLogPersistence
 * @see DailyLogUtil
 * @generated
 */
public class DailyLogPersistenceImpl extends BasePersistenceImpl<DailyLog>
    implements DailyLogPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link DailyLogUtil} to access the daily log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = DailyLogImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogModelImpl.FINDER_CACHE_ENABLED, DailyLogImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogModelImpl.FINDER_CACHE_ENABLED, DailyLogImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_DAILYLOGID = new FinderPath(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogModelImpl.FINDER_CACHE_ENABLED, DailyLogImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchBydailyLogId",
            new String[] { Long.class.getName() },
            DailyLogModelImpl.DAILYLOGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DAILYLOGID = new FinderPath(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydailyLogId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_DAILYLOGID_DAILYLOGID_2 = "dailyLog.dailyLogId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSIGNMENT_ID =
        new FinderPath(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogModelImpl.FINDER_CACHE_ENABLED, DailyLogImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByassignment_id",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENT_ID =
        new FinderPath(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogModelImpl.FINDER_CACHE_ENABLED, DailyLogImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByassignment_id",
            new String[] { Long.class.getName() },
            DailyLogModelImpl.ASSIGNMENT_ID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ASSIGNMENT_ID = new FinderPath(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByassignment_id",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_ASSIGNMENT_ID_ASSIGNMENT_ID_2 = "dailyLog.assignment_id = ?";
    private static final String _SQL_SELECT_DAILYLOG = "SELECT dailyLog FROM DailyLog dailyLog";
    private static final String _SQL_SELECT_DAILYLOG_WHERE = "SELECT dailyLog FROM DailyLog dailyLog WHERE ";
    private static final String _SQL_COUNT_DAILYLOG = "SELECT COUNT(dailyLog) FROM DailyLog dailyLog";
    private static final String _SQL_COUNT_DAILYLOG_WHERE = "SELECT COUNT(dailyLog) FROM DailyLog dailyLog WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "dailyLog.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DailyLog exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DailyLog exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(DailyLogPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "date"
            });
    private static DailyLog _nullDailyLog = new DailyLogImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<DailyLog> toCacheModel() {
                return _nullDailyLogCacheModel;
            }
        };

    private static CacheModel<DailyLog> _nullDailyLogCacheModel = new CacheModel<DailyLog>() {
            @Override
            public DailyLog toEntityModel() {
                return _nullDailyLog;
            }
        };

    public DailyLogPersistenceImpl() {
        setModelClass(DailyLog.class);
    }

    /**
     * Returns the daily log where dailyLogId = &#63; or throws a {@link ms3.service.NoSuchDailyLogException} if it could not be found.
     *
     * @param dailyLogId the daily log ID
     * @return the matching daily log
     * @throws ms3.service.NoSuchDailyLogException if a matching daily log could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog findBydailyLogId(long dailyLogId)
        throws NoSuchDailyLogException, SystemException {
        DailyLog dailyLog = fetchBydailyLogId(dailyLogId);

        if (dailyLog == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("dailyLogId=");
            msg.append(dailyLogId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchDailyLogException(msg.toString());
        }

        return dailyLog;
    }

    /**
     * Returns the daily log where dailyLogId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param dailyLogId the daily log ID
     * @return the matching daily log, or <code>null</code> if a matching daily log could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog fetchBydailyLogId(long dailyLogId)
        throws SystemException {
        return fetchBydailyLogId(dailyLogId, true);
    }

    /**
     * Returns the daily log where dailyLogId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param dailyLogId the daily log ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching daily log, or <code>null</code> if a matching daily log could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog fetchBydailyLogId(long dailyLogId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { dailyLogId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DAILYLOGID,
                    finderArgs, this);
        }

        if (result instanceof DailyLog) {
            DailyLog dailyLog = (DailyLog) result;

            if ((dailyLogId != dailyLog.getDailyLogId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_DAILYLOG_WHERE);

            query.append(_FINDER_COLUMN_DAILYLOGID_DAILYLOGID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(dailyLogId);

                List<DailyLog> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DAILYLOGID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "DailyLogPersistenceImpl.fetchBydailyLogId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    DailyLog dailyLog = list.get(0);

                    result = dailyLog;

                    cacheResult(dailyLog);

                    if ((dailyLog.getDailyLogId() != dailyLogId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DAILYLOGID,
                            finderArgs, dailyLog);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DAILYLOGID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (DailyLog) result;
        }
    }

    /**
     * Removes the daily log where dailyLogId = &#63; from the database.
     *
     * @param dailyLogId the daily log ID
     * @return the daily log that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog removeBydailyLogId(long dailyLogId)
        throws NoSuchDailyLogException, SystemException {
        DailyLog dailyLog = findBydailyLogId(dailyLogId);

        return remove(dailyLog);
    }

    /**
     * Returns the number of daily logs where dailyLogId = &#63;.
     *
     * @param dailyLogId the daily log ID
     * @return the number of matching daily logs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBydailyLogId(long dailyLogId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_DAILYLOGID;

        Object[] finderArgs = new Object[] { dailyLogId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DAILYLOG_WHERE);

            query.append(_FINDER_COLUMN_DAILYLOGID_DAILYLOGID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(dailyLogId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the daily logs where assignment_id = &#63;.
     *
     * @param assignment_id the assignment_id
     * @return the matching daily logs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DailyLog> findByassignment_id(long assignment_id)
        throws SystemException {
        return findByassignment_id(assignment_id, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<DailyLog> findByassignment_id(long assignment_id, int start,
        int end) throws SystemException {
        return findByassignment_id(assignment_id, start, end, null);
    }

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
    @Override
    public List<DailyLog> findByassignment_id(long assignment_id, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENT_ID;
            finderArgs = new Object[] { assignment_id };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ASSIGNMENT_ID;
            finderArgs = new Object[] {
                    assignment_id,
                    
                    start, end, orderByComparator
                };
        }

        List<DailyLog> list = (List<DailyLog>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (DailyLog dailyLog : list) {
                if ((assignment_id != dailyLog.getAssignment_id())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_DAILYLOG_WHERE);

            query.append(_FINDER_COLUMN_ASSIGNMENT_ID_ASSIGNMENT_ID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(DailyLogModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assignment_id);

                if (!pagination) {
                    list = (List<DailyLog>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DailyLog>(list);
                } else {
                    list = (List<DailyLog>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first daily log in the ordered set where assignment_id = &#63;.
     *
     * @param assignment_id the assignment_id
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching daily log
     * @throws ms3.service.NoSuchDailyLogException if a matching daily log could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog findByassignment_id_First(long assignment_id,
        OrderByComparator orderByComparator)
        throws NoSuchDailyLogException, SystemException {
        DailyLog dailyLog = fetchByassignment_id_First(assignment_id,
                orderByComparator);

        if (dailyLog != null) {
            return dailyLog;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("assignment_id=");
        msg.append(assignment_id);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDailyLogException(msg.toString());
    }

    /**
     * Returns the first daily log in the ordered set where assignment_id = &#63;.
     *
     * @param assignment_id the assignment_id
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching daily log, or <code>null</code> if a matching daily log could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog fetchByassignment_id_First(long assignment_id,
        OrderByComparator orderByComparator) throws SystemException {
        List<DailyLog> list = findByassignment_id(assignment_id, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last daily log in the ordered set where assignment_id = &#63;.
     *
     * @param assignment_id the assignment_id
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching daily log
     * @throws ms3.service.NoSuchDailyLogException if a matching daily log could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog findByassignment_id_Last(long assignment_id,
        OrderByComparator orderByComparator)
        throws NoSuchDailyLogException, SystemException {
        DailyLog dailyLog = fetchByassignment_id_Last(assignment_id,
                orderByComparator);

        if (dailyLog != null) {
            return dailyLog;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("assignment_id=");
        msg.append(assignment_id);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchDailyLogException(msg.toString());
    }

    /**
     * Returns the last daily log in the ordered set where assignment_id = &#63;.
     *
     * @param assignment_id the assignment_id
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching daily log, or <code>null</code> if a matching daily log could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog fetchByassignment_id_Last(long assignment_id,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByassignment_id(assignment_id);

        if (count == 0) {
            return null;
        }

        List<DailyLog> list = findByassignment_id(assignment_id, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

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
    @Override
    public DailyLog[] findByassignment_id_PrevAndNext(long dailyLogId,
        long assignment_id, OrderByComparator orderByComparator)
        throws NoSuchDailyLogException, SystemException {
        DailyLog dailyLog = findByPrimaryKey(dailyLogId);

        Session session = null;

        try {
            session = openSession();

            DailyLog[] array = new DailyLogImpl[3];

            array[0] = getByassignment_id_PrevAndNext(session, dailyLog,
                    assignment_id, orderByComparator, true);

            array[1] = dailyLog;

            array[2] = getByassignment_id_PrevAndNext(session, dailyLog,
                    assignment_id, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected DailyLog getByassignment_id_PrevAndNext(Session session,
        DailyLog dailyLog, long assignment_id,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_DAILYLOG_WHERE);

        query.append(_FINDER_COLUMN_ASSIGNMENT_ID_ASSIGNMENT_ID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(DailyLogModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(assignment_id);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(dailyLog);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<DailyLog> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the daily logs where assignment_id = &#63; from the database.
     *
     * @param assignment_id the assignment_id
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByassignment_id(long assignment_id)
        throws SystemException {
        for (DailyLog dailyLog : findByassignment_id(assignment_id,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(dailyLog);
        }
    }

    /**
     * Returns the number of daily logs where assignment_id = &#63;.
     *
     * @param assignment_id the assignment_id
     * @return the number of matching daily logs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByassignment_id(long assignment_id)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ASSIGNMENT_ID;

        Object[] finderArgs = new Object[] { assignment_id };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_DAILYLOG_WHERE);

            query.append(_FINDER_COLUMN_ASSIGNMENT_ID_ASSIGNMENT_ID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assignment_id);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the daily log in the entity cache if it is enabled.
     *
     * @param dailyLog the daily log
     */
    @Override
    public void cacheResult(DailyLog dailyLog) {
        EntityCacheUtil.putResult(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogImpl.class, dailyLog.getPrimaryKey(), dailyLog);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DAILYLOGID,
            new Object[] { dailyLog.getDailyLogId() }, dailyLog);

        dailyLog.resetOriginalValues();
    }

    /**
     * Caches the daily logs in the entity cache if it is enabled.
     *
     * @param dailyLogs the daily logs
     */
    @Override
    public void cacheResult(List<DailyLog> dailyLogs) {
        for (DailyLog dailyLog : dailyLogs) {
            if (EntityCacheUtil.getResult(
                        DailyLogModelImpl.ENTITY_CACHE_ENABLED,
                        DailyLogImpl.class, dailyLog.getPrimaryKey()) == null) {
                cacheResult(dailyLog);
            } else {
                dailyLog.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all daily logs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(DailyLogImpl.class.getName());
        }

        EntityCacheUtil.clearCache(DailyLogImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the daily log.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(DailyLog dailyLog) {
        EntityCacheUtil.removeResult(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogImpl.class, dailyLog.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(dailyLog);
    }

    @Override
    public void clearCache(List<DailyLog> dailyLogs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (DailyLog dailyLog : dailyLogs) {
            EntityCacheUtil.removeResult(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
                DailyLogImpl.class, dailyLog.getPrimaryKey());

            clearUniqueFindersCache(dailyLog);
        }
    }

    protected void cacheUniqueFindersCache(DailyLog dailyLog) {
        if (dailyLog.isNew()) {
            Object[] args = new Object[] { dailyLog.getDailyLogId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAILYLOGID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DAILYLOGID, args,
                dailyLog);
        } else {
            DailyLogModelImpl dailyLogModelImpl = (DailyLogModelImpl) dailyLog;

            if ((dailyLogModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_DAILYLOGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { dailyLog.getDailyLogId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAILYLOGID,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DAILYLOGID,
                    args, dailyLog);
            }
        }
    }

    protected void clearUniqueFindersCache(DailyLog dailyLog) {
        DailyLogModelImpl dailyLogModelImpl = (DailyLogModelImpl) dailyLog;

        Object[] args = new Object[] { dailyLog.getDailyLogId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DAILYLOGID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DAILYLOGID, args);

        if ((dailyLogModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_DAILYLOGID.getColumnBitmask()) != 0) {
            args = new Object[] { dailyLogModelImpl.getOriginalDailyLogId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DAILYLOGID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DAILYLOGID, args);
        }
    }

    /**
     * Creates a new daily log with the primary key. Does not add the daily log to the database.
     *
     * @param dailyLogId the primary key for the new daily log
     * @return the new daily log
     */
    @Override
    public DailyLog create(long dailyLogId) {
        DailyLog dailyLog = new DailyLogImpl();

        dailyLog.setNew(true);
        dailyLog.setPrimaryKey(dailyLogId);

        return dailyLog;
    }

    /**
     * Removes the daily log with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param dailyLogId the primary key of the daily log
     * @return the daily log that was removed
     * @throws ms3.service.NoSuchDailyLogException if a daily log with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog remove(long dailyLogId)
        throws NoSuchDailyLogException, SystemException {
        return remove((Serializable) dailyLogId);
    }

    /**
     * Removes the daily log with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the daily log
     * @return the daily log that was removed
     * @throws ms3.service.NoSuchDailyLogException if a daily log with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog remove(Serializable primaryKey)
        throws NoSuchDailyLogException, SystemException {
        Session session = null;

        try {
            session = openSession();

            DailyLog dailyLog = (DailyLog) session.get(DailyLogImpl.class,
                    primaryKey);

            if (dailyLog == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDailyLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(dailyLog);
        } catch (NoSuchDailyLogException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected DailyLog removeImpl(DailyLog dailyLog) throws SystemException {
        dailyLog = toUnwrappedModel(dailyLog);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(dailyLog)) {
                dailyLog = (DailyLog) session.get(DailyLogImpl.class,
                        dailyLog.getPrimaryKeyObj());
            }

            if (dailyLog != null) {
                session.delete(dailyLog);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (dailyLog != null) {
            clearCache(dailyLog);
        }

        return dailyLog;
    }

    @Override
    public DailyLog updateImpl(ms3.service.model.DailyLog dailyLog)
        throws SystemException {
        dailyLog = toUnwrappedModel(dailyLog);

        boolean isNew = dailyLog.isNew();

        DailyLogModelImpl dailyLogModelImpl = (DailyLogModelImpl) dailyLog;

        Session session = null;

        try {
            session = openSession();

            if (dailyLog.isNew()) {
                session.save(dailyLog);

                dailyLog.setNew(false);
            } else {
                session.merge(dailyLog);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !DailyLogModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((dailyLogModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENT_ID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        dailyLogModelImpl.getOriginalAssignment_id()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSIGNMENT_ID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENT_ID,
                    args);

                args = new Object[] { dailyLogModelImpl.getAssignment_id() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ASSIGNMENT_ID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ASSIGNMENT_ID,
                    args);
            }
        }

        EntityCacheUtil.putResult(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
            DailyLogImpl.class, dailyLog.getPrimaryKey(), dailyLog);

        clearUniqueFindersCache(dailyLog);
        cacheUniqueFindersCache(dailyLog);

        return dailyLog;
    }

    protected DailyLog toUnwrappedModel(DailyLog dailyLog) {
        if (dailyLog instanceof DailyLogImpl) {
            return dailyLog;
        }

        DailyLogImpl dailyLogImpl = new DailyLogImpl();

        dailyLogImpl.setNew(dailyLog.isNew());
        dailyLogImpl.setPrimaryKey(dailyLog.getPrimaryKey());

        dailyLogImpl.setDailyLogId(dailyLog.getDailyLogId());
        dailyLogImpl.setAssignment_id(dailyLog.getAssignment_id());
        dailyLogImpl.setDate(dailyLog.getDate());
        dailyLogImpl.setAccomplishments(dailyLog.getAccomplishments());
        dailyLogImpl.setRoadblocks(dailyLog.getRoadblocks());
        dailyLogImpl.setPlan(dailyLog.getPlan());
        dailyLogImpl.setNotes(dailyLog.getNotes());
        dailyLogImpl.setHours(dailyLog.getHours());
        dailyLogImpl.setSection(dailyLog.getSection());

        return dailyLogImpl;
    }

    /**
     * Returns the daily log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the daily log
     * @return the daily log
     * @throws ms3.service.NoSuchDailyLogException if a daily log with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog findByPrimaryKey(Serializable primaryKey)
        throws NoSuchDailyLogException, SystemException {
        DailyLog dailyLog = fetchByPrimaryKey(primaryKey);

        if (dailyLog == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDailyLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return dailyLog;
    }

    /**
     * Returns the daily log with the primary key or throws a {@link ms3.service.NoSuchDailyLogException} if it could not be found.
     *
     * @param dailyLogId the primary key of the daily log
     * @return the daily log
     * @throws ms3.service.NoSuchDailyLogException if a daily log with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog findByPrimaryKey(long dailyLogId)
        throws NoSuchDailyLogException, SystemException {
        return findByPrimaryKey((Serializable) dailyLogId);
    }

    /**
     * Returns the daily log with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the daily log
     * @return the daily log, or <code>null</code> if a daily log with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        DailyLog dailyLog = (DailyLog) EntityCacheUtil.getResult(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
                DailyLogImpl.class, primaryKey);

        if (dailyLog == _nullDailyLog) {
            return null;
        }

        if (dailyLog == null) {
            Session session = null;

            try {
                session = openSession();

                dailyLog = (DailyLog) session.get(DailyLogImpl.class, primaryKey);

                if (dailyLog != null) {
                    cacheResult(dailyLog);
                } else {
                    EntityCacheUtil.putResult(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
                        DailyLogImpl.class, primaryKey, _nullDailyLog);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(DailyLogModelImpl.ENTITY_CACHE_ENABLED,
                    DailyLogImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return dailyLog;
    }

    /**
     * Returns the daily log with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param dailyLogId the primary key of the daily log
     * @return the daily log, or <code>null</code> if a daily log with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DailyLog fetchByPrimaryKey(long dailyLogId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) dailyLogId);
    }

    /**
     * Returns all the daily logs.
     *
     * @return the daily logs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DailyLog> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<DailyLog> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<DailyLog> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<DailyLog> list = (List<DailyLog>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_DAILYLOG);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_DAILYLOG;

                if (pagination) {
                    sql = sql.concat(DailyLogModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<DailyLog>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DailyLog>(list);
                } else {
                    list = (List<DailyLog>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the daily logs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (DailyLog dailyLog : findAll()) {
            remove(dailyLog);
        }
    }

    /**
     * Returns the number of daily logs.
     *
     * @return the number of daily logs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_DAILYLOG);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the daily log persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ms3.service.model.DailyLog")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<DailyLog>> listenersList = new ArrayList<ModelListener<DailyLog>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<DailyLog>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(DailyLogImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
