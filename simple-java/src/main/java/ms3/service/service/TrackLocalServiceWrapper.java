package ms3.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrackLocalService}.
 *
 * @author jackt
 * @see TrackLocalService
 * @generated
 */
public class TrackLocalServiceWrapper implements TrackLocalService,
    ServiceWrapper<TrackLocalService> {
    private TrackLocalService _trackLocalService;

    public TrackLocalServiceWrapper(TrackLocalService trackLocalService) {
        _trackLocalService = trackLocalService;
    }

    /**
    * Adds the track to the database. Also notifies the appropriate model listeners.
    *
    * @param track the track
    * @return the track that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ms3.service.model.Track addTrack(ms3.service.model.Track track)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackLocalService.addTrack(track);
    }

    /**
    * Creates a new track with the primary key. Does not add the track to the database.
    *
    * @param trackId the primary key for the new track
    * @return the new track
    */
    @Override
    public ms3.service.model.Track createTrack(long trackId) {
        return _trackLocalService.createTrack(trackId);
    }

    /**
    * Deletes the track with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param trackId the primary key of the track
    * @return the track that was removed
    * @throws PortalException if a track with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ms3.service.model.Track deleteTrack(long trackId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _trackLocalService.deleteTrack(trackId);
    }

    /**
    * Deletes the track from the database. Also notifies the appropriate model listeners.
    *
    * @param track the track
    * @return the track that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ms3.service.model.Track deleteTrack(ms3.service.model.Track track)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackLocalService.deleteTrack(track);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _trackLocalService.dynamicQuery();
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
        return _trackLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _trackLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ms3.service.model.impl.TrackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _trackLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _trackLocalService.dynamicQueryCount(dynamicQuery);
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
        return _trackLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public ms3.service.model.Track fetchTrack(long trackId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackLocalService.fetchTrack(trackId);
    }

    /**
    * Returns the track with the primary key.
    *
    * @param trackId the primary key of the track
    * @return the track
    * @throws PortalException if a track with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ms3.service.model.Track getTrack(long trackId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _trackLocalService.getTrack(trackId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _trackLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<ms3.service.model.Track> getTracks(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackLocalService.getTracks(start, end);
    }

    /**
    * Returns the number of tracks.
    *
    * @return the number of tracks
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getTracksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackLocalService.getTracksCount();
    }

    /**
    * Updates the track in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param track the track
    * @return the track that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public ms3.service.model.Track updateTrack(ms3.service.model.Track track)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _trackLocalService.updateTrack(track);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _trackLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _trackLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _trackLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TrackLocalService getWrappedTrackLocalService() {
        return _trackLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTrackLocalService(TrackLocalService trackLocalService) {
        _trackLocalService = trackLocalService;
    }

    @Override
    public TrackLocalService getWrappedService() {
        return _trackLocalService;
    }

    @Override
    public void setWrappedService(TrackLocalService trackLocalService) {
        _trackLocalService = trackLocalService;
    }
}
