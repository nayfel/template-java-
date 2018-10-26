package ms3.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ms3.service.model.Track;

import java.util.List;

/**
 * The persistence utility for the track service. This utility wraps {@link TrackPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jackt
 * @see TrackPersistence
 * @see TrackPersistenceImpl
 * @generated
 */
public class TrackUtil {
    private static TrackPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Track track) {
        getPersistence().clearCache(track);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Track> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Track> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Track> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Track update(Track track) throws SystemException {
        return getPersistence().update(track);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Track update(Track track, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(track, serviceContext);
    }

    /**
    * Returns the track where trackId = &#63; or throws a {@link ms3.service.NoSuchTrackException} if it could not be found.
    *
    * @param trackId the track ID
    * @return the matching track
    * @throws ms3.service.NoSuchTrackException if a matching track could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Track findBytrackId(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackException {
        return getPersistence().findBytrackId(trackId);
    }

    /**
    * Returns the track where trackId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param trackId the track ID
    * @return the matching track, or <code>null</code> if a matching track could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Track fetchBytrackId(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytrackId(trackId);
    }

    /**
    * Returns the track where trackId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param trackId the track ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching track, or <code>null</code> if a matching track could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Track fetchBytrackId(long trackId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytrackId(trackId, retrieveFromCache);
    }

    /**
    * Removes the track where trackId = &#63; from the database.
    *
    * @param trackId the track ID
    * @return the track that was removed
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Track removeBytrackId(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackException {
        return getPersistence().removeBytrackId(trackId);
    }

    /**
    * Returns the number of tracks where trackId = &#63;.
    *
    * @param trackId the track ID
    * @return the number of matching tracks
    * @throws SystemException if a system exception occurred
    */
    public static int countBytrackId(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBytrackId(trackId);
    }

    /**
    * Caches the track in the entity cache if it is enabled.
    *
    * @param track the track
    */
    public static void cacheResult(ms3.service.model.Track track) {
        getPersistence().cacheResult(track);
    }

    /**
    * Caches the tracks in the entity cache if it is enabled.
    *
    * @param tracks the tracks
    */
    public static void cacheResult(
        java.util.List<ms3.service.model.Track> tracks) {
        getPersistence().cacheResult(tracks);
    }

    /**
    * Creates a new track with the primary key. Does not add the track to the database.
    *
    * @param trackId the primary key for the new track
    * @return the new track
    */
    public static ms3.service.model.Track create(long trackId) {
        return getPersistence().create(trackId);
    }

    /**
    * Removes the track with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param trackId the primary key of the track
    * @return the track that was removed
    * @throws ms3.service.NoSuchTrackException if a track with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Track remove(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackException {
        return getPersistence().remove(trackId);
    }

    public static ms3.service.model.Track updateImpl(
        ms3.service.model.Track track)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(track);
    }

    /**
    * Returns the track with the primary key or throws a {@link ms3.service.NoSuchTrackException} if it could not be found.
    *
    * @param trackId the primary key of the track
    * @return the track
    * @throws ms3.service.NoSuchTrackException if a track with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Track findByPrimaryKey(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackException {
        return getPersistence().findByPrimaryKey(trackId);
    }

    /**
    * Returns the track with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param trackId the primary key of the track
    * @return the track, or <code>null</code> if a track with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.Track fetchByPrimaryKey(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(trackId);
    }

    /**
    * Returns all the tracks.
    *
    * @return the tracks
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ms3.service.model.Track> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<ms3.service.model.Track> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<ms3.service.model.Track> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the tracks from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of tracks.
    *
    * @return the number of tracks
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static TrackPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (TrackPersistence) PortletBeanLocatorUtil.locate(ms3.service.service.ClpSerializer.getServletContextName(),
                    TrackPersistence.class.getName());

            ReferenceRegistry.registerReference(TrackUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(TrackPersistence persistence) {
    }
}
