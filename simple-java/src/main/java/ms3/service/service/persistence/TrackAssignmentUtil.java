package ms3.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import ms3.service.model.TrackAssignment;

import java.util.List;

/**
 * The persistence utility for the track assignment service. This utility wraps {@link TrackAssignmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jackt
 * @see TrackAssignmentPersistence
 * @see TrackAssignmentPersistenceImpl
 * @generated
 */
public class TrackAssignmentUtil {
    private static TrackAssignmentPersistence _persistence;

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
    public static void clearCache(TrackAssignment trackAssignment) {
        getPersistence().clearCache(trackAssignment);
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
    public static List<TrackAssignment> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<TrackAssignment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<TrackAssignment> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static TrackAssignment update(TrackAssignment trackAssignment)
        throws SystemException {
        return getPersistence().update(trackAssignment);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static TrackAssignment update(TrackAssignment trackAssignment,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(trackAssignment, serviceContext);
    }

    /**
    * Returns all the track assignments where userScreenName = &#63;.
    *
    * @param userScreenName the user screen name
    * @return the matching track assignments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ms3.service.model.TrackAssignment> findByuserScreenName(
        java.lang.String userScreenName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuserScreenName(userScreenName);
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
    public static java.util.List<ms3.service.model.TrackAssignment> findByuserScreenName(
        java.lang.String userScreenName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByuserScreenName(userScreenName, start, end);
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
    public static java.util.List<ms3.service.model.TrackAssignment> findByuserScreenName(
        java.lang.String userScreenName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByuserScreenName(userScreenName, start, end,
            orderByComparator);
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
    public static ms3.service.model.TrackAssignment findByuserScreenName_First(
        java.lang.String userScreenName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException {
        return getPersistence()
                   .findByuserScreenName_First(userScreenName, orderByComparator);
    }

    /**
    * Returns the first track assignment in the ordered set where userScreenName = &#63;.
    *
    * @param userScreenName the user screen name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching track assignment, or <code>null</code> if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.TrackAssignment fetchByuserScreenName_First(
        java.lang.String userScreenName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByuserScreenName_First(userScreenName,
            orderByComparator);
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
    public static ms3.service.model.TrackAssignment findByuserScreenName_Last(
        java.lang.String userScreenName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException {
        return getPersistence()
                   .findByuserScreenName_Last(userScreenName, orderByComparator);
    }

    /**
    * Returns the last track assignment in the ordered set where userScreenName = &#63;.
    *
    * @param userScreenName the user screen name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching track assignment, or <code>null</code> if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.TrackAssignment fetchByuserScreenName_Last(
        java.lang.String userScreenName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByuserScreenName_Last(userScreenName, orderByComparator);
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
    public static ms3.service.model.TrackAssignment[] findByuserScreenName_PrevAndNext(
        long trackAssignmentId, java.lang.String userScreenName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException {
        return getPersistence()
                   .findByuserScreenName_PrevAndNext(trackAssignmentId,
            userScreenName, orderByComparator);
    }

    /**
    * Removes all the track assignments where userScreenName = &#63; from the database.
    *
    * @param userScreenName the user screen name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByuserScreenName(java.lang.String userScreenName)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByuserScreenName(userScreenName);
    }

    /**
    * Returns the number of track assignments where userScreenName = &#63;.
    *
    * @param userScreenName the user screen name
    * @return the number of matching track assignments
    * @throws SystemException if a system exception occurred
    */
    public static int countByuserScreenName(java.lang.String userScreenName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByuserScreenName(userScreenName);
    }

    /**
    * Returns all the track assignments where trackId = &#63;.
    *
    * @param trackId the track ID
    * @return the matching track assignments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ms3.service.model.TrackAssignment> findBytrackId(
        long trackId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytrackId(trackId);
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
    public static java.util.List<ms3.service.model.TrackAssignment> findBytrackId(
        long trackId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBytrackId(trackId, start, end);
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
    public static java.util.List<ms3.service.model.TrackAssignment> findBytrackId(
        long trackId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBytrackId(trackId, start, end, orderByComparator);
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
    public static ms3.service.model.TrackAssignment findBytrackId_First(
        long trackId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException {
        return getPersistence().findBytrackId_First(trackId, orderByComparator);
    }

    /**
    * Returns the first track assignment in the ordered set where trackId = &#63;.
    *
    * @param trackId the track ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching track assignment, or <code>null</code> if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.TrackAssignment fetchBytrackId_First(
        long trackId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytrackId_First(trackId, orderByComparator);
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
    public static ms3.service.model.TrackAssignment findBytrackId_Last(
        long trackId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException {
        return getPersistence().findBytrackId_Last(trackId, orderByComparator);
    }

    /**
    * Returns the last track assignment in the ordered set where trackId = &#63;.
    *
    * @param trackId the track ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching track assignment, or <code>null</code> if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.TrackAssignment fetchBytrackId_Last(
        long trackId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchBytrackId_Last(trackId, orderByComparator);
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
    public static ms3.service.model.TrackAssignment[] findBytrackId_PrevAndNext(
        long trackAssignmentId, long trackId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException {
        return getPersistence()
                   .findBytrackId_PrevAndNext(trackAssignmentId, trackId,
            orderByComparator);
    }

    /**
    * Removes all the track assignments where trackId = &#63; from the database.
    *
    * @param trackId the track ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBytrackId(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBytrackId(trackId);
    }

    /**
    * Returns the number of track assignments where trackId = &#63;.
    *
    * @param trackId the track ID
    * @return the number of matching track assignments
    * @throws SystemException if a system exception occurred
    */
    public static int countBytrackId(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBytrackId(trackId);
    }

    /**
    * Caches the track assignment in the entity cache if it is enabled.
    *
    * @param trackAssignment the track assignment
    */
    public static void cacheResult(
        ms3.service.model.TrackAssignment trackAssignment) {
        getPersistence().cacheResult(trackAssignment);
    }

    /**
    * Caches the track assignments in the entity cache if it is enabled.
    *
    * @param trackAssignments the track assignments
    */
    public static void cacheResult(
        java.util.List<ms3.service.model.TrackAssignment> trackAssignments) {
        getPersistence().cacheResult(trackAssignments);
    }

    /**
    * Creates a new track assignment with the primary key. Does not add the track assignment to the database.
    *
    * @param trackAssignmentId the primary key for the new track assignment
    * @return the new track assignment
    */
    public static ms3.service.model.TrackAssignment create(
        long trackAssignmentId) {
        return getPersistence().create(trackAssignmentId);
    }

    /**
    * Removes the track assignment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param trackAssignmentId the primary key of the track assignment
    * @return the track assignment that was removed
    * @throws ms3.service.NoSuchTrackAssignmentException if a track assignment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.TrackAssignment remove(
        long trackAssignmentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException {
        return getPersistence().remove(trackAssignmentId);
    }

    public static ms3.service.model.TrackAssignment updateImpl(
        ms3.service.model.TrackAssignment trackAssignment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(trackAssignment);
    }

    /**
    * Returns the track assignment with the primary key or throws a {@link ms3.service.NoSuchTrackAssignmentException} if it could not be found.
    *
    * @param trackAssignmentId the primary key of the track assignment
    * @return the track assignment
    * @throws ms3.service.NoSuchTrackAssignmentException if a track assignment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.TrackAssignment findByPrimaryKey(
        long trackAssignmentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException {
        return getPersistence().findByPrimaryKey(trackAssignmentId);
    }

    /**
    * Returns the track assignment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param trackAssignmentId the primary key of the track assignment
    * @return the track assignment, or <code>null</code> if a track assignment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static ms3.service.model.TrackAssignment fetchByPrimaryKey(
        long trackAssignmentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(trackAssignmentId);
    }

    /**
    * Returns all the track assignments.
    *
    * @return the track assignments
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<ms3.service.model.TrackAssignment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<ms3.service.model.TrackAssignment> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<ms3.service.model.TrackAssignment> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the track assignments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of track assignments.
    *
    * @return the number of track assignments
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static TrackAssignmentPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (TrackAssignmentPersistence) PortletBeanLocatorUtil.locate(ms3.service.service.ClpSerializer.getServletContextName(),
                    TrackAssignmentPersistence.class.getName());

            ReferenceRegistry.registerReference(TrackAssignmentUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(TrackAssignmentPersistence persistence) {
    }
}
