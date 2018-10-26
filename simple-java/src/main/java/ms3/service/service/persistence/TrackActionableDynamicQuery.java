package ms3.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ms3.service.model.Track;

import ms3.service.service.TrackLocalServiceUtil;

/**
 * @author jackt
 * @generated
 */
public abstract class TrackActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TrackActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TrackLocalServiceUtil.getService());
        setClass(Track.class);

        setClassLoader(ms3.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("trackId");
    }
}
