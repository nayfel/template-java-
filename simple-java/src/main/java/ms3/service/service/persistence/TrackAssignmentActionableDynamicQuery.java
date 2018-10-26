package ms3.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ms3.service.model.TrackAssignment;

import ms3.service.service.TrackAssignmentLocalServiceUtil;

/**
 * @author jackt
 * @generated
 */
public abstract class TrackAssignmentActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TrackAssignmentActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TrackAssignmentLocalServiceUtil.getService());
        setClass(TrackAssignment.class);

        setClassLoader(ms3.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("trackAssignmentId");
    }
}
