package ms3.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ms3.service.model.TrackAssignment;

/**
 * The persistence interface for the track assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jackt
 * @see TrackAssignmentPersistenceImpl
 * @see TrackAssignmentUtil
 * @generated
 */
public interface TrackAssignmentPersistence extends BasePersistence<TrackAssignment> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link TrackAssignmentUtil} to access the track assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the track assignments where userScreenName = &#63;.
    *
    * @param userScreenName the user screen name
    * @return the matching track assignments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ms3.service.model.TrackAssignment> findByuserScreenName(
        java.lang.String userScreenName)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ms3.service.model.TrackAssignment> findByuserScreenName(
        java.lang.String userScreenName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ms3.service.model.TrackAssignment> findByuserScreenName(
        java.lang.String userScreenName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first track assignment in the ordered set where userScreenName = &#63;.
    *
    * @param userScreenName the user screen name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching track assignment
    * @throws ms3.service.NoSuchTrackAssignmentException if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment findByuserScreenName_First(
        java.lang.String userScreenName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException;

    /**
    * Returns the first track assignment in the ordered set where userScreenName = &#63;.
    *
    * @param userScreenName the user screen name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching track assignment, or <code>null</code> if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment fetchByuserScreenName_First(
        java.lang.String userScreenName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last track assignment in the ordered set where userScreenName = &#63;.
    *
    * @param userScreenName the user screen name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching track assignment
    * @throws ms3.service.NoSuchTrackAssignmentException if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment findByuserScreenName_Last(
        java.lang.String userScreenName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException;

    /**
    * Returns the last track assignment in the ordered set where userScreenName = &#63;.
    *
    * @param userScreenName the user screen name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching track assignment, or <code>null</code> if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment fetchByuserScreenName_Last(
        java.lang.String userScreenName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public ms3.service.model.TrackAssignment[] findByuserScreenName_PrevAndNext(
        long trackAssignmentId, java.lang.String userScreenName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException;

    /**
    * Removes all the track assignments where userScreenName = &#63; from the database.
    *
    * @param userScreenName the user screen name
    * @throws SystemException if a system exception occurred
    */
    public void removeByuserScreenName(java.lang.String userScreenName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of track assignments where userScreenName = &#63;.
    *
    * @param userScreenName the user screen name
    * @return the number of matching track assignments
    * @throws SystemException if a system exception occurred
    */
    public int countByuserScreenName(java.lang.String userScreenName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the track assignments where trackId = &#63;.
    *
    * @param trackId the track ID
    * @return the matching track assignments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ms3.service.model.TrackAssignment> findBytrackId(
        long trackId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ms3.service.model.TrackAssignment> findBytrackId(
        long trackId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ms3.service.model.TrackAssignment> findBytrackId(
        long trackId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first track assignment in the ordered set where trackId = &#63;.
    *
    * @param trackId the track ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching track assignment
    * @throws ms3.service.NoSuchTrackAssignmentException if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment findBytrackId_First(long trackId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException;

    /**
    * Returns the first track assignment in the ordered set where trackId = &#63;.
    *
    * @param trackId the track ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching track assignment, or <code>null</code> if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment fetchBytrackId_First(
        long trackId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last track assignment in the ordered set where trackId = &#63;.
    *
    * @param trackId the track ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching track assignment
    * @throws ms3.service.NoSuchTrackAssignmentException if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment findBytrackId_Last(long trackId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException;

    /**
    * Returns the last track assignment in the ordered set where trackId = &#63;.
    *
    * @param trackId the track ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching track assignment, or <code>null</code> if a matching track assignment could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment fetchBytrackId_Last(long trackId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public ms3.service.model.TrackAssignment[] findBytrackId_PrevAndNext(
        long trackAssignmentId, long trackId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException;

    /**
    * Removes all the track assignments where trackId = &#63; from the database.
    *
    * @param trackId the track ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBytrackId(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of track assignments where trackId = &#63;.
    *
    * @param trackId the track ID
    * @return the number of matching track assignments
    * @throws SystemException if a system exception occurred
    */
    public int countBytrackId(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the track assignment in the entity cache if it is enabled.
    *
    * @param trackAssignment the track assignment
    */
    public void cacheResult(ms3.service.model.TrackAssignment trackAssignment);

    /**
    * Caches the track assignments in the entity cache if it is enabled.
    *
    * @param trackAssignments the track assignments
    */
    public void cacheResult(
        java.util.List<ms3.service.model.TrackAssignment> trackAssignments);

    /**
    * Creates a new track assignment with the primary key. Does not add the track assignment to the database.
    *
    * @param trackAssignmentId the primary key for the new track assignment
    * @return the new track assignment
    */
    public ms3.service.model.TrackAssignment create(long trackAssignmentId);

    /**
    * Removes the track assignment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param trackAssignmentId the primary key of the track assignment
    * @return the track assignment that was removed
    * @throws ms3.service.NoSuchTrackAssignmentException if a track assignment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment remove(long trackAssignmentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException;

    public ms3.service.model.TrackAssignment updateImpl(
        ms3.service.model.TrackAssignment trackAssignment)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the track assignment with the primary key or throws a {@link ms3.service.NoSuchTrackAssignmentException} if it could not be found.
    *
    * @param trackAssignmentId the primary key of the track assignment
    * @return the track assignment
    * @throws ms3.service.NoSuchTrackAssignmentException if a track assignment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment findByPrimaryKey(
        long trackAssignmentId)
        throws com.liferay.portal.kernel.exception.SystemException,
            ms3.service.NoSuchTrackAssignmentException;

    /**
    * Returns the track assignment with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param trackAssignmentId the primary key of the track assignment
    * @return the track assignment, or <code>null</code> if a track assignment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ms3.service.model.TrackAssignment fetchByPrimaryKey(
        long trackAssignmentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the track assignments.
    *
    * @return the track assignments
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ms3.service.model.TrackAssignment> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ms3.service.model.TrackAssignment> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<ms3.service.model.TrackAssignment> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the track assignments from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of track assignments.
    *
    * @return the number of track assignments
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
