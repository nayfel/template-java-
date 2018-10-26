package ms3.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import ms3.service.model.DailyLog;

import ms3.service.service.DailyLogLocalServiceUtil;

/**
 * @author jackt
 * @generated
 */
public abstract class DailyLogActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DailyLogActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DailyLogLocalServiceUtil.getService());
        setClass(DailyLog.class);

        setClassLoader(ms3.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("dailyLogId");
    }
}
