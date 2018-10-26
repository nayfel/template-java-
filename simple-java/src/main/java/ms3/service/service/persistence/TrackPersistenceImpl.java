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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import ms3.service.NoSuchTrackException;

import ms3.service.model.Track;
import ms3.service.model.impl.TrackImpl;
import ms3.service.model.impl.TrackModelImpl;

import ms3.service.service.persistence.TrackPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the track service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jackt
 * @see TrackPersistence
 * @see TrackUtil
 * @generated
 */
public class TrackPersistenceImpl extends BasePersistenceImpl<Track>
    implements TrackPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link TrackUtil} to access the track persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = TrackImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TrackModelImpl.ENTITY_CACHE_ENABLED,
            TrackModelImpl.FINDER_CACHE_ENABLED, TrackImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TrackModelImpl.ENTITY_CACHE_ENABLED,
            TrackModelImpl.FINDER_CACHE_ENABLED, TrackImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TrackModelImpl.ENTITY_CACHE_ENABLED,
            TrackModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_TRACKID = new FinderPath(TrackModelImpl.ENTITY_CACHE_ENABLED,
            TrackModelImpl.FINDER_CACHE_ENABLED, TrackImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchBytrackId",
            new String[] { Long.class.getName() },
            TrackModelImpl.TRACKID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TRACKID = new FinderPath(TrackModelImpl.ENTITY_CACHE_ENABLED,
            TrackModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytrackId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_TRACKID_TRACKID_2 = "track.trackId = ?";
    private static final String _SQL_SELECT_TRACK = "SELECT track FROM Track track";
    private static final String _SQL_SELECT_TRACK_WHERE = "SELECT track FROM Track track WHERE ";
    private static final String _SQL_COUNT_TRACK = "SELECT COUNT(track) FROM Track track";
    private static final String _SQL_COUNT_TRACK_WHERE = "SELECT COUNT(track) FROM Track track WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "track.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Track exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Track exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(TrackPersistenceImpl.class);
    private static Track _nullTrack = new TrackImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Track> toCacheModel() {
                return _nullTrackCacheModel;
            }
        };

    private static CacheModel<Track> _nullTrackCacheModel = new CacheModel<Track>() {
            @Override
            public Track toEntityModel() {
                return _nullTrack;
            }
        };

    public TrackPersistenceImpl() {
        setModelClass(Track.class);
    }

    /**
     * Returns the track where trackId = &#63; or throws a {@link ms3.service.NoSuchTrackException} if it could not be found.
     *
     * @param trackId the track ID
     * @return the matching track
     * @throws ms3.service.NoSuchTrackException if a matching track could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Track findBytrackId(long trackId)
        throws NoSuchTrackException, SystemException {
        Track track = fetchBytrackId(trackId);

        if (track == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("trackId=");
            msg.append(trackId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchTrackException(msg.toString());
        }

        return track;
    }

    /**
     * Returns the track where trackId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param trackId the track ID
     * @return the matching track, or <code>null</code> if a matching track could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Track fetchBytrackId(long trackId) throws SystemException {
        return fetchBytrackId(trackId, true);
    }

    /**
     * Returns the track where trackId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param trackId the track ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching track, or <code>null</code> if a matching track could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Track fetchBytrackId(long trackId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { trackId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TRACKID,
                    finderArgs, this);
        }

        if (result instanceof Track) {
            Track track = (Track) result;

            if ((trackId != track.getTrackId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_TRACK_WHERE);

            query.append(_FINDER_COLUMN_TRACKID_TRACKID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(trackId);

                List<Track> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TRACKID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "TrackPersistenceImpl.fetchBytrackId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Track track = list.get(0);

                    result = track;

                    cacheResult(track);

                    if ((track.getTrackId() != trackId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TRACKID,
                            finderArgs, track);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TRACKID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Track) result;
        }
    }

    /**
     * Removes the track where trackId = &#63; from the database.
     *
     * @param trackId the track ID
     * @return the track that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Track removeBytrackId(long trackId)
        throws NoSuchTrackException, SystemException {
        Track track = findBytrackId(trackId);

        return remove(track);
    }

    /**
     * Returns the number of tracks where trackId = &#63;.
     *
     * @param trackId the track ID
     * @return the number of matching tracks
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

            query.append(_SQL_COUNT_TRACK_WHERE);

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
     * Caches the track in the entity cache if it is enabled.
     *
     * @param track the track
     */
    @Override
    public void cacheResult(Track track) {
        EntityCacheUtil.putResult(TrackModelImpl.ENTITY_CACHE_ENABLED,
            TrackImpl.class, track.getPrimaryKey(), track);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TRACKID,
            new Object[] { track.getTrackId() }, track);

        track.resetOriginalValues();
    }

    /**
     * Caches the tracks in the entity cache if it is enabled.
     *
     * @param tracks the tracks
     */
    @Override
    public void cacheResult(List<Track> tracks) {
        for (Track track : tracks) {
            if (EntityCacheUtil.getResult(TrackModelImpl.ENTITY_CACHE_ENABLED,
                        TrackImpl.class, track.getPrimaryKey()) == null) {
                cacheResult(track);
            } else {
                track.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all tracks.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(TrackImpl.class.getName());
        }

        EntityCacheUtil.clearCache(TrackImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the track.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Track track) {
        EntityCacheUtil.removeResult(TrackModelImpl.ENTITY_CACHE_ENABLED,
            TrackImpl.class, track.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(track);
    }

    @Override
    public void clearCache(List<Track> tracks) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Track track : tracks) {
            EntityCacheUtil.removeResult(TrackModelImpl.ENTITY_CACHE_ENABLED,
                TrackImpl.class, track.getPrimaryKey());

            clearUniqueFindersCache(track);
        }
    }

    protected void cacheUniqueFindersCache(Track track) {
        if (track.isNew()) {
            Object[] args = new Object[] { track.getTrackId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRACKID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TRACKID, args, track);
        } else {
            TrackModelImpl trackModelImpl = (TrackModelImpl) track;

            if ((trackModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_TRACKID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { track.getTrackId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRACKID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TRACKID, args,
                    track);
            }
        }
    }

    protected void clearUniqueFindersCache(Track track) {
        TrackModelImpl trackModelImpl = (TrackModelImpl) track;

        Object[] args = new Object[] { track.getTrackId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRACKID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TRACKID, args);

        if ((trackModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_TRACKID.getColumnBitmask()) != 0) {
            args = new Object[] { trackModelImpl.getOriginalTrackId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRACKID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TRACKID, args);
        }
    }

    /**
     * Creates a new track with the primary key. Does not add the track to the database.
     *
     * @param trackId the primary key for the new track
     * @return the new track
     */
    @Override
    public Track create(long trackId) {
        Track track = new TrackImpl();

        track.setNew(true);
        track.setPrimaryKey(trackId);

        return track;
    }

    /**
     * Removes the track with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param trackId the primary key of the track
     * @return the track that was removed
     * @throws ms3.service.NoSuchTrackException if a track with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Track remove(long trackId)
        throws NoSuchTrackException, SystemException {
        return remove((Serializable) trackId);
    }

    /**
     * Removes the track with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the track
     * @return the track that was removed
     * @throws ms3.service.NoSuchTrackException if a track with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Track remove(Serializable primaryKey)
        throws NoSuchTrackException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Track track = (Track) session.get(TrackImpl.class, primaryKey);

            if (track == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchTrackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(track);
        } catch (NoSuchTrackException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Track removeImpl(Track track) throws SystemException {
        track = toUnwrappedModel(track);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(track)) {
                track = (Track) session.get(TrackImpl.class,
                        track.getPrimaryKeyObj());
            }

            if (track != null) {
                session.delete(track);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (track != null) {
            clearCache(track);
        }

        return track;
    }

    @Override
    public Track updateImpl(ms3.service.model.Track track)
        throws SystemException {
        track = toUnwrappedModel(track);

        boolean isNew = track.isNew();

        Session session = null;

        try {
            session = openSession();

            if (track.isNew()) {
                session.save(track);

                track.setNew(false);
            } else {
                session.merge(track);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !TrackModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(TrackModelImpl.ENTITY_CACHE_ENABLED,
            TrackImpl.class, track.getPrimaryKey(), track);

        clearUniqueFindersCache(track);
        cacheUniqueFindersCache(track);

        return track;
    }

    protected Track toUnwrappedModel(Track track) {
        if (track instanceof TrackImpl) {
            return track;
        }

        TrackImpl trackImpl = new TrackImpl();

        trackImpl.setNew(track.isNew());
        trackImpl.setPrimaryKey(track.getPrimaryKey());

        trackImpl.setTrackId(track.getTrackId());
        trackImpl.setTitle(track.getTitle());
        trackImpl.setDescription(track.getDescription());
        trackImpl.setCourseList(track.getCourseList());
        trackImpl.setAccreditation(track.getAccreditation());

        return trackImpl;
    }

    /**
     * Returns the track with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the track
     * @return the track
     * @throws ms3.service.NoSuchTrackException if a track with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Track findByPrimaryKey(Serializable primaryKey)
        throws NoSuchTrackException, SystemException {
        Track track = fetchByPrimaryKey(primaryKey);

        if (track == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchTrackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return track;
    }

    /**
     * Returns the track with the primary key or throws a {@link ms3.service.NoSuchTrackException} if it could not be found.
     *
     * @param trackId the primary key of the track
     * @return the track
     * @throws ms3.service.NoSuchTrackException if a track with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Track findByPrimaryKey(long trackId)
        throws NoSuchTrackException, SystemException {
        return findByPrimaryKey((Serializable) trackId);
    }

    /**
     * Returns the track with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the track
     * @return the track, or <code>null</code> if a track with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Track fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Track track = (Track) EntityCacheUtil.getResult(TrackModelImpl.ENTITY_CACHE_ENABLED,
                TrackImpl.class, primaryKey);

        if (track == _nullTrack) {
            return null;
        }

        if (track == null) {
            Session session = null;

            try {
                session = openSession();

                track = (Track) session.get(TrackImpl.class, primaryKey);

                if (track != null) {
                    cacheResult(track);
                } else {
                    EntityCacheUtil.putResult(TrackModelImpl.ENTITY_CACHE_ENABLED,
                        TrackImpl.class, primaryKey, _nullTrack);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(TrackModelImpl.ENTITY_CACHE_ENABLED,
                    TrackImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return track;
    }

    /**
     * Returns the track with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param trackId the primary key of the track
     * @return the track, or <code>null</code> if a track with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Track fetchByPrimaryKey(long trackId) throws SystemException {
        return fetchByPrimaryKey((Serializable) trackId);
    }

    /**
     * Returns all the tracks.
     *
     * @return the tracks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Track> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the tracks.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of tracks
     * @param end the upper bound of the range of tracks (not inclusive)
     * @return the range of tracks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Track> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the tracks.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of tracks
     * @param end the upper bound of the range of tracks (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of tracks
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Track> findAll(int start, int end,
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

        List<Track> list = (List<Track>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_TRACK);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_TRACK;

                if (pagination) {
                    sql = sql.concat(TrackModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Track>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Track>(list);
                } else {
                    list = (List<Track>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the tracks from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Track track : findAll()) {
            remove(track);
        }
    }

    /**
     * Returns the number of tracks.
     *
     * @return the number of tracks
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

                Query q = session.createQuery(_SQL_COUNT_TRACK);

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
     * Initializes the track persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.ms3.service.model.Track")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Track>> listenersList = new ArrayList<ModelListener<Track>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Track>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(TrackImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
