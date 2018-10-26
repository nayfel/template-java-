package ms3.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrackAssignmentLocalService}.
 *
 * @author jackt
 * @see TrackAssignmentLocalService
 * @generated
 */
public class TrackAssignmentLocalServiceWrapper
    implements TrackAssignmentLocalService,
        ServiceWrapper<TrackAssignmentLocalService> {
    private TrackAssignmentLocalService _trackAssignmentLocalService;

    public TrackAssignmentLocalServiceWrapper(
        TrackAssignmentLocalService trackAssignmentLocalService) {
        _trackAssignmentLocalService = trackAssignmentLocalService;
    }

    /**
    * Adds the track assignment to the database. Also notifies the appropriate model listeners.
    *
    * @param trackAssignment the track assignment
    * @return the track assignment that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ms3.service.model.TrackAssignment addTrackAssignment(
        ms3.service.model.TrackAssignment trackAssignment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.addTrackAssignment(trackAssignment);
    }

    /**
    * Creates a new track assignment with the primary key. Does not add the track assignment to the database.
    *
    * @param trackAssignmentId the primary key for the new track assignment
    * @return the new track assignment
    */
    @Override
    public ms3.service.model.TrackAssignment createTrackAssignment(
        long trackAssignmentId) {
        return _trackAssignmentLocalService.createTrackAssignment(trackAssignmentId);
    }

    /**
    * Deletes the track assignment with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param trackAssignmentId the primary key of the track assignment
    * @return the track assignment that was removed
    * @throws PortalException if a track assignment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ms3.service.model.TrackAssignment deleteTrackAssignment(
        long trackAssignmentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.deleteTrackAssignment(trackAssignmentId);
    }

    /**
    * Deletes the track assignment from the database. Also notifies the appropriate model listeners.
    *
    * @param trackAssignment the track assignment
    * @return the track assignment that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ms3.service.model.TrackAssignment deleteTrackAssignment(
        ms3.service.model.TrackAssignment trackAssignment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.deleteTrackAssignment(trackAssignment);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _trackAssignmentLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public ms3.service.model.TrackAssignment fetchTrackAssignment(
        long trackAssignmentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.fetchTrackAssignment(trackAssignmentId);
    }

    /**
    * Returns the track assignment with the primary key.
    *
    * @param trackAssignmentId the primary key of the track assignment
    * @return the track assignment
    * @throws PortalException if a track assignment with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ms3.service.model.TrackAssignment getTrackAssignment(
        long trackAssignmentId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.getTrackAssignment(trackAssignmentId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<ms3.service.model.TrackAssignment> getTrackAssignments(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.getTrackAssignments(start, end);
    }

    /**
    * Returns the number of track assignments.
    *
    * @return the number of track assignments
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getTrackAssignmentsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.getTrackAssignmentsCount();
    }

    /**
    * Updates the track assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param trackAssignment the track assignment
    * @return the track assignment that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ms3.service.model.TrackAssignment updateTrackAssignment(
        ms3.service.model.TrackAssignment trackAssignment)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackAssignmentLocalService.updateTrackAssignment(trackAssignment);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _trackAssignmentLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _trackAssignmentLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _trackAssignmentLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TrackAssignmentLocalService getWrappedTrackAssignmentLocalService() {
        return _trackAssignmentLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTrackAssignmentLocalService(
        TrackAssignmentLocalService trackAssignmentLocalService) {
        _trackAssignmentLocalService = trackAssignmentLocalService;
    }

    @Override
    public TrackAssignmentLocalService getWrappedService() {
        return _trackAssignmentLocalService;
    }

    @Override
    public void setWrappedService(
        TrackAssignmentLocalService trackAssignmentLocalService) {
        _trackAssignmentLocalService = trackAssignmentLocalService;
    }
}
