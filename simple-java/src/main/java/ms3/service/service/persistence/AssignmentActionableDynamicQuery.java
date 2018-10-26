package ms3.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ms3.service.model.Assignment;

import ms3.service.service.AssignmentLocalServiceUtil;

/**
 * @author jackt
 * @generated
 */
public abstract class AssignmentActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AssignmentActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AssignmentLocalServiceUtil.getService());
        setClass(Assignment.class);

        setClassLoader(ms3.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("assignmentId");
    }
}
