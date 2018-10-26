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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ms3.service.NoSuchTrackAssignmentException;

import ms3.service.model.TrackAssignment;
import ms3.service.model.impl.TrackAssignmentImpl;
import ms3.service.model.impl.TrackAssignmentModelImpl;

import ms3.service.service.persistence.TrackAssignmentPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the track assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jackt
 * @see TrackAssignmentPersistence
 * @see TrackAssignmentUtil
 * @generated
 */
public class TrackAssignmentPersistenceImpl extends BasePersistenceImpl<TrackAssignment>
    implements TrackAssignmentPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link TrackAssignmentUtil} to access the track assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = TrackAssignmentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentModelImpl.FINDER_CACHE_ENABLED,
            TrackAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentModelImpl.FINDER_CACHE_ENABLED,
            TrackAssignmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSCREENNAME =
        new FinderPath(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentModelImpl.FINDER_CACHE_ENABLED,
            TrackAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByuserScreenName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSCREENNAME =
        new FinderPath(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentModelImpl.FINDER_CACHE_ENABLED,
            TrackAssignmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserScreenName",
            new String[] { String.class.getName() },
            TrackAssignmentModelImpl.USERSCREENNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERSCREENNAME = new FinderPath(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserScreenName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_1 = "trackAssignment.userScreenName IS NULL";
    private static final String _FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_2 = "trackAssignment.userScreenName = ?";
    private static final String _FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_3 = "(trackAssignment.userScreenName IS NULL OR trackAssignment.userScreenName = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRACKID = new FinderPath(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentModelImpl.FINDER_CACHE_ENABLED,
            TrackAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findBytrackId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACKID =
        new FinderPath(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentModelImpl.FINDER_CACHE_ENABLED,
            TrackAssignmentImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytrackId",
            new String[] { Long.class.getName() },
            TrackAssignmentModelImpl.TRACKID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TRACKID = new FinderPath(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytrackId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_TRACKID_TRACKID_2 = "trackAssignment.trackId = ?";
    private static final String _SQL_SELECT_TRACKASSIGNMENT = "SELECT trackAssignment FROM TrackAssignment trackAssignment";
    private static final String _SQL_SELECT_TRACKASSIGNMENT_WHERE = "SELECT trackAssignment FROM TrackAssignment trackAssignment WHERE ";
    private static final String _SQL_COUNT_TRACKASSIGNMENT = "SELECT COUNT(trackAssignment) FROM TrackAssignment trackAssignment";
    private static final String _SQL_COUNT_TRACKASSIGNMENT_WHERE = "SELECT COUNT(trackAssignment) FROM TrackAssignment trackAssignment WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "trackAssignment.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TrackAssignment exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TrackAssignment exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(TrackAssignmentPersistenceImpl.class);
    private static TrackAssignment _nullTrackAssignment = new TrackAssignmentImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<TrackAssignment> toCacheModel() {
                return _nullTrackAssignmentCacheModel;
            }
        };

    private static CacheModel<TrackAssignment> _nullTrackAssignmentCacheModel = new CacheModel<TrackAssignment>() {
            @Override
            public TrackAssignment toEntityModel() {
                return _nullTrackAssignment;
            }
        };

    public TrackAssignmentPersistenceImpl() {
        setModelClass(TrackAssignment.class);
    }

    /**
     * Returns all the track assignments where userScreenName = &#63;.
     *
     * @param userScreenName the user screen name
     * @return the matching track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TrackAssignment> findByuserScreenName(String userScreenName)
        throws SystemException {
        return findByuserScreenName(userScreenName, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the track assignments where userScreenName = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userScreenName the user screen name
     * @param start the lower bound of the range of track assignments
     * @param end the upper bound of the range of track assignments (not inclusive)
     * @return the range of matching track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TrackAssignment> findByuserScreenName(String userScreenName,
        int start, int end) throws SystemException {
        return findByuserScreenName(userScreenName, start, end, null);
    }

    /**
     * Returns an ordered range of all the track assignments where userScreenName = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param userScreenName the user screen name
     * @param start the lower bound of the range of track assignments
     * @param end the upper bound of the range of track assignments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TrackAssignment> findByuserScreenName(String userScreenName,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSCREENNAME;
            finderArgs = new Object[] { userScreenName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSCREENNAME;
            finderArgs = new Object[] {
                    userScreenName,
                    
                    start, end, orderByComparator
                };
        }

        List<TrackAssignment> list = (List<TrackAssignment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (TrackAssignment trackAssignment : list) {
                if (!Validator.equals(userScreenName,
                            trackAssignment.getUserScreenName())) {
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

            query.append(_SQL_SELECT_TRACKASSIGNMENT_WHERE);

            boolean bindUserScreenName = false;

            if (userScreenName == null) {
                query.append(_FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_1);
            } else if (userScreenName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_3);
            } else {
                bindUserScreenName = true;

                query.append(_FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TrackAssignmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUserScreenName) {
                    qPos.add(userScreenName);
                }

                if (!pagination) {
                    list = (List<TrackAssignment>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<TrackAssignment>(list);
                } else {
                    list = (List<TrackAssignment>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first track assignment in the ordered set where userScreenName = &#63;.
     *
     * @param userScreenName the user screen name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching track assignment
     * @throws ms3.service.NoSuchTrackAssignmentException if a matching track assignment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment findByuserScreenName_First(String userScreenName,
        OrderByComparator orderByComparator)
        throws NoSuchTrackAssignmentException, SystemException {
        TrackAssignment trackAssignment = fetchByuserScreenName_First(userScreenName,
                orderByComparator);

        if (trackAssignment != null) {
            return trackAssignment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userScreenName=");
        msg.append(userScreenName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTrackAssignmentException(msg.toString());
    }

    /**
     * Returns the first track assignment in the ordered set where userScreenName = &#63;.
     *
     * @param userScreenName the user screen name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching track assignment, or <code>null</code> if a matching track assignment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment fetchByuserScreenName_First(String userScreenName,
        OrderByComparator orderByComparator) throws SystemException {
        List<TrackAssignment> list = findByuserScreenName(userScreenName, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last track assignment in the ordered set where userScreenName = &#63;.
     *
     * @param userScreenName the user screen name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching track assignment
     * @throws ms3.service.NoSuchTrackAssignmentException if a matching track assignment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment findByuserScreenName_Last(String userScreenName,
        OrderByComparator orderByComparator)
        throws NoSuchTrackAssignmentException, SystemException {
        TrackAssignment trackAssignment = fetchByuserScreenName_Last(userScreenName,
                orderByComparator);

        if (trackAssignment != null) {
            return trackAssignment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userScreenName=");
        msg.append(userScreenName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTrackAssignmentException(msg.toString());
    }

    /**
     * Returns the last track assignment in the ordered set where userScreenName = &#63;.
     *
     * @param userScreenName the user screen name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching track assignment, or <code>null</code> if a matching track assignment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment fetchByuserScreenName_Last(String userScreenName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByuserScreenName(userScreenName);

        if (count == 0) {
            return null;
        }

        List<TrackAssignment> list = findByuserScreenName(userScreenName,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the track assignments before and after the current track assignment in the ordered set where userScreenName = &#63;.
     *
     * @param trackAssignmentId the primary key of the current track assignment
     * @param userScreenName the user screen name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next track assignment
     * @throws ms3.service.NoSuchTrackAssignmentException if a track assignment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment[] findByuserScreenName_PrevAndNext(
        long trackAssignmentId, String userScreenName,
        OrderByComparator orderByComparator)
        throws NoSuchTrackAssignmentException, SystemException {
        TrackAssignment trackAssignment = findByPrimaryKey(trackAssignmentId);

        Session session = null;

        try {
            session = openSession();

            TrackAssignment[] array = new TrackAssignmentImpl[3];

            array[0] = getByuserScreenName_PrevAndNext(session,
                    trackAssignment, userScreenName, orderByComparator, true);

            array[1] = trackAssignment;

            array[2] = getByuserScreenName_PrevAndNext(session,
                    trackAssignment, userScreenName, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected TrackAssignment getByuserScreenName_PrevAndNext(Session session,
        TrackAssignment trackAssignment, String userScreenName,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TRACKASSIGNMENT_WHERE);

        boolean bindUserScreenName = false;

        if (userScreenName == null) {
            query.append(_FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_1);
        } else if (userScreenName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_3);
        } else {
            bindUserScreenName = true;

            query.append(_FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_2);
        }

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
            query.append(TrackAssignmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindUserScreenName) {
            qPos.add(userScreenName);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(trackAssignment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<TrackAssignment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the track assignments where userScreenName = &#63; from the database.
     *
     * @param userScreenName the user screen name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByuserScreenName(String userScreenName)
        throws SystemException {
        for (TrackAssignment trackAssignment : findByuserScreenName(
                userScreenName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(trackAssignment);
        }
    }

    /**
     * Returns the number of track assignments where userScreenName = &#63;.
     *
     * @param userScreenName the user screen name
     * @return the number of matching track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByuserScreenName(String userScreenName)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERSCREENNAME;

        Object[] finderArgs = new Object[] { userScreenName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TRACKASSIGNMENT_WHERE);

            boolean bindUserScreenName = false;

            if (userScreenName == null) {
                query.append(_FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_1);
            } else if (userScreenName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_3);
            } else {
                bindUserScreenName = true;

                query.append(_FINDER_COLUMN_USERSCREENNAME_USERSCREENNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindUserScreenName) {
                    qPos.add(userScreenName);
                }

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
     * Returns all the track assignments where trackId = &#63;.
     *
     * @param trackId the track ID
     * @return the matching track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TrackAssignment> findBytrackId(long trackId)
        throws SystemException {
        return findBytrackId(trackId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the track assignments where trackId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param trackId the track ID
     * @param start the lower bound of the range of track assignments
     * @param end the upper bound of the range of track assignments (not inclusive)
     * @return the range of matching track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TrackAssignment> findBytrackId(long trackId, int start, int end)
        throws SystemException {
        return findBytrackId(trackId, start, end, null);
    }

    /**
     * Returns an ordered range of all the track assignments where trackId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param trackId the track ID
     * @param start the lower bound of the range of track assignments
     * @param end the upper bound of the range of track assignments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TrackAssignment> findBytrackId(long trackId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACKID;
            finderArgs = new Object[] { trackId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRACKID;
            finderArgs = new Object[] { trackId, start, end, orderByComparator };
        }

        List<TrackAssignment> list = (List<TrackAssignment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (TrackAssignment trackAssignment : list) {
                if ((trackId != trackAssignment.getTrackId())) {
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

            query.append(_SQL_SELECT_TRACKASSIGNMENT_WHERE);

            query.append(_FINDER_COLUMN_TRACKID_TRACKID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TrackAssignmentModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(trackId);

                if (!pagination) {
                    list = (List<TrackAssignment>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<TrackAssignment>(list);
                } else {
                    list = (List<TrackAssignment>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first track assignment in the ordered set where trackId = &#63;.
     *
     * @param trackId the track ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching track assignment
     * @throws ms3.service.NoSuchTrackAssignmentException if a matching track assignment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment findBytrackId_First(long trackId,
        OrderByComparator orderByComparator)
        throws NoSuchTrackAssignmentException, SystemException {
        TrackAssignment trackAssignment = fetchBytrackId_First(trackId,
                orderByComparator);

        if (trackAssignment != null) {
            return trackAssignment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("trackId=");
        msg.append(trackId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTrackAssignmentException(msg.toString());
    }

    /**
     * Returns the first track assignment in the ordered set where trackId = &#63;.
     *
     * @param trackId the track ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching track assignment, or <code>null</code> if a matching track assignment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment fetchBytrackId_First(long trackId,
        OrderByComparator orderByComparator) throws SystemException {
        List<TrackAssignment> list = findBytrackId(trackId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last track assignment in the ordered set where trackId = &#63;.
     *
     * @param trackId the track ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching track assignment
     * @throws ms3.service.NoSuchTrackAssignmentException if a matching track assignment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment findBytrackId_Last(long trackId,
        OrderByComparator orderByComparator)
        throws NoSuchTrackAssignmentException, SystemException {
        TrackAssignment trackAssignment = fetchBytrackId_Last(trackId,
                orderByComparator);

        if (trackAssignment != null) {
            return trackAssignment;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("trackId=");
        msg.append(trackId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTrackAssignmentException(msg.toString());
    }

    /**
     * Returns the last track assignment in the ordered set where trackId = &#63;.
     *
     * @param trackId the track ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching track assignment, or <code>null</code> if a matching track assignment could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment fetchBytrackId_Last(long trackId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countBytrackId(trackId);

        if (count == 0) {
            return null;
        }

        List<TrackAssignment> list = findBytrackId(trackId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the track assignments before and after the current track assignment in the ordered set where trackId = &#63;.
     *
     * @param trackAssignmentId the primary key of the current track assignment
     * @param trackId the track ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next track assignment
     * @throws ms3.service.NoSuchTrackAssignmentException if a track assignment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment[] findBytrackId_PrevAndNext(long trackAssignmentId,
        long trackId, OrderByComparator orderByComparator)
        throws NoSuchTrackAssignmentException, SystemException {
        TrackAssignment trackAssignment = findByPrimaryKey(trackAssignmentId);

        Session session = null;

        try {
            session = openSession();

            TrackAssignment[] array = new TrackAssignmentImpl[3];

            array[0] = getBytrackId_PrevAndNext(session, trackAssignment,
                    trackId, orderByComparator, true);

            array[1] = trackAssignment;

            array[2] = getBytrackId_PrevAndNext(session, trackAssignment,
                    trackId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected TrackAssignment getBytrackId_PrevAndNext(Session session,
        TrackAssignment trackAssignment, long trackId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TRACKASSIGNMENT_WHERE);

        query.append(_FINDER_COLUMN_TRACKID_TRACKID_2);

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
            query.append(TrackAssignmentModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(trackId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(trackAssignment);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<TrackAssignment> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the track assignments where trackId = &#63; from the database.
     *
     * @param trackId the track ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeBytrackId(long trackId) throws SystemException {
        for (TrackAssignment trackAssignment : findBytrackId(trackId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(trackAssignment);
        }
    }

    /**
     * Returns the number of track assignments where trackId = &#63;.
     *
     * @param trackId the track ID
     * @return the number of matching track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countBytrackId(long trackId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TRACKID;

        Object[] finderArgs = new Object[] { trackId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TRACKASSIGNMENT_WHERE);

            query.append(_FINDER_COLUMN_TRACKID_TRACKID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(trackId);

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
     * Caches the track assignment in the entity cache if it is enabled.
     *
     * @param trackAssignment the track assignment
     */
    @Override
    public void cacheResult(TrackAssignment trackAssignment) {
        EntityCacheUtil.putResult(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentImpl.class, trackAssignment.getPrimaryKey(),
            trackAssignment);

        trackAssignment.resetOriginalValues();
    }

    /**
     * Caches the track assignments in the entity cache if it is enabled.
     *
     * @param trackAssignments the track assignments
     */
    @Override
    public void cacheResult(List<TrackAssignment> trackAssignments) {
        for (TrackAssignment trackAssignment : trackAssignments) {
            if (EntityCacheUtil.getResult(
                        TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
                        TrackAssignmentImpl.class,
                        trackAssignment.getPrimaryKey()) == null) {
                cacheResult(trackAssignment);
            } else {
                trackAssignment.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all track assignments.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(TrackAssignmentImpl.class.getName());
        }

        EntityCacheUtil.clearCache(TrackAssignmentImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the track assignment.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(TrackAssignment trackAssignment) {
        EntityCacheUtil.removeResult(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentImpl.class, trackAssignment.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<TrackAssignment> trackAssignments) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (TrackAssignment trackAssignment : trackAssignments) {
            EntityCacheUtil.removeResult(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
                TrackAssignmentImpl.class, trackAssignment.getPrimaryKey());
        }
    }

    /**
     * Creates a new track assignment with the primary key. Does not add the track assignment to the database.
     *
     * @param trackAssignmentId the primary key for the new track assignment
     * @return the new track assignment
     */
    @Override
    public TrackAssignment create(long trackAssignmentId) {
        TrackAssignment trackAssignment = new TrackAssignmentImpl();

        trackAssignment.setNew(true);
        trackAssignment.setPrimaryKey(trackAssignmentId);

        return trackAssignment;
    }

    /**
     * Removes the track assignment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param trackAssignmentId the primary key of the track assignment
     * @return the track assignment that was removed
     * @throws ms3.service.NoSuchTrackAssignmentException if a track assignment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment remove(long trackAssignmentId)
        throws NoSuchTrackAssignmentException, SystemException {
        return remove((Serializable) trackAssignmentId);
    }

    /**
     * Removes the track assignment with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the track assignment
     * @return the track assignment that was removed
     * @throws ms3.service.NoSuchTrackAssignmentException if a track assignment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment remove(Serializable primaryKey)
        throws NoSuchTrackAssignmentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            TrackAssignment trackAssignment = (TrackAssignment) session.get(TrackAssignmentImpl.class,
                    primaryKey);

            if (trackAssignment == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchTrackAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(trackAssignment);
        } catch (NoSuchTrackAssignmentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected TrackAssignment removeImpl(TrackAssignment trackAssignment)
        throws SystemException {
        trackAssignment = toUnwrappedModel(trackAssignment);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(trackAssignment)) {
                trackAssignment = (TrackAssignment) session.get(TrackAssignmentImpl.class,
                        trackAssignment.getPrimaryKeyObj());
            }

            if (trackAssignment != null) {
                session.delete(trackAssignment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (trackAssignment != null) {
            clearCache(trackAssignment);
        }

        return trackAssignment;
    }

    @Override
    public TrackAssignment updateImpl(
        ms3.service.model.TrackAssignment trackAssignment)
        throws SystemException {
        trackAssignment = toUnwrappedModel(trackAssignment);

        boolean isNew = trackAssignment.isNew();

        TrackAssignmentModelImpl trackAssignmentModelImpl = (TrackAssignmentModelImpl) trackAssignment;

        Session session = null;

        try {
            session = openSession();

            if (trackAssignment.isNew()) {
                session.save(trackAssignment);

                trackAssignment.setNew(false);
            } else {
                session.merge(trackAssignment);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !TrackAssignmentModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((trackAssignmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSCREENNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        trackAssignmentModelImpl.getOriginalUserScreenName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERSCREENNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSCREENNAME,
                    args);

                args = new Object[] { trackAssignmentModelImpl.getUserScreenName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERSCREENNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSCREENNAME,
                    args);
            }

            if ((trackAssignmentModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACKID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        trackAssignmentModelImpl.getOriginalTrackId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRACKID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACKID,
                    args);

                args = new Object[] { trackAssignmentModelImpl.getTrackId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRACKID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRACKID,
                    args);
            }
        }

        EntityCacheUtil.putResult(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
            TrackAssignmentImpl.class, trackAssignment.getPrimaryKey(),
            trackAssignment);

        return trackAssignment;
    }

    protected TrackAssignment toUnwrappedModel(TrackAssignment trackAssignment) {
        if (trackAssignment instanceof TrackAssignmentImpl) {
            return trackAssignment;
        }

        TrackAssignmentImpl trackAssignmentImpl = new TrackAssignmentImpl();

        trackAssignmentImpl.setNew(trackAssignment.isNew());
        trackAssignmentImpl.setPrimaryKey(trackAssignment.getPrimaryKey());

        trackAssignmentImpl.setTrackAssignmentId(trackAssignment.getTrackAssignmentId());
        trackAssignmentImpl.setTrackId(trackAssignment.getTrackId());
        trackAssignmentImpl.setUserScreenName(trackAssignment.getUserScreenName());
        trackAssignmentImpl.setAssignmentIdList(trackAssignment.getAssignmentIdList());
        trackAssignmentImpl.setDateAssigned(trackAssignment.getDateAssigned());
        trackAssignmentImpl.setAdmin(trackAssignment.getAdmin());

        return trackAssignmentImpl;
    }

    /**
     * Returns the track assignment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the track assignment
     * @return the track assignment
     * @throws ms3.service.NoSuchTrackAssignmentException if a track assignment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment findByPrimaryKey(Serializable primaryKey)
        throws NoSuchTrackAssignmentException, SystemException {
        TrackAssignment trackAssignment = fetchByPrimaryKey(primaryKey);

        if (trackAssignment == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchTrackAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return trackAssignment;
    }

    /**
     * Returns the track assignment with the primary key or throws a {@link ms3.service.NoSuchTrackAssignmentException} if it could not be found.
     *
     * @param trackAssignmentId the primary key of the track assignment
     * @return the track assignment
     * @throws ms3.service.NoSuchTrackAssignmentException if a track assignment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment findByPrimaryKey(long trackAssignmentId)
        throws NoSuchTrackAssignmentException, SystemException {
        return findByPrimaryKey((Serializable) trackAssignmentId);
    }

    /**
     * Returns the track assignment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the track assignment
     * @return the track assignment, or <code>null</code> if a track assignment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        TrackAssignment trackAssignment = (TrackAssignment) EntityCacheUtil.getResult(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
                TrackAssignmentImpl.class, primaryKey);

        if (trackAssignment == _nullTrackAssignment) {
            return null;
        }

        if (trackAssignment == null) {
            Session session = null;

            try {
                session = openSession();

                trackAssignment = (TrackAssignment) session.get(TrackAssignmentImpl.class,
                        primaryKey);

                if (trackAssignment != null) {
                    cacheResult(trackAssignment);
                } else {
                    EntityCacheUtil.putResult(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
                        TrackAssignmentImpl.class, primaryKey,
                        _nullTrackAssignment);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(TrackAssignmentModelImpl.ENTITY_CACHE_ENABLED,
                    TrackAssignmentImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return trackAssignment;
    }

    /**
     * Returns the track assignment with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param trackAssignmentId the primary key of the track assignment
     * @return the track assignment, or <code>null</code> if a track assignment with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TrackAssignment fetchByPrimaryKey(long trackAssignmentId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) trackAssignmentId);
    }

    /**
     * Returns all the track assignments.
     *
     * @return the track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TrackAssignment> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the track assignments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of track assignments
     * @param end the upper bound of the range of track assignments (not inclusive)
     * @return the range of track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TrackAssignment> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the track assignments.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of track assignments
     * @param end the upper bound of the range of track assignments (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of track assignments
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TrackAssignment> findAll(int start, int end,
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

        List<TrackAssignment> list = (List<TrackAssignment>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_TRACKASSIGNMENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_TRACKASSIGNMENT;

                if (pagination) {
                    sql = sql.concat(TrackAssignmentModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<TrackAssignment>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<TrackAssignment>(list);
                } else {
                    list = (List<TrackAssignment>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the track assignments from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (TrackAssignment trackAssignment : findAll()) {
            remove(trackAssignment);
        }
    }

    /**
     * Returns the number of track assignments.
     *
     * @return the number of track assignments
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

                Query q = session.createQuery(_SQL_COUNT_TRACKASSIGNMENT);

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

    /**
     * Initializes the track assignment persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ms3.service.model.TrackAssignment")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<TrackAssignment>> listenersList = new ArrayList<ModelListener<TrackAssignment>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<TrackAssignment>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(TrackAssignmentImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
