package ms3.service.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import ms3.service.model.DailyLog;

import ms3.service.service.DailyLogLocalServiceUtil;

/**
 * The extended model base implementation for the DailyLog service. Represents a row in the &quot;train_DailyLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DailyLogImpl}.
 * </p>
 *
 * @author jackt
 * @see DailyLogImpl
 * @see ms3.service.model.DailyLog
 * @generated
 */
public abstract class DailyLogBaseImpl extends DailyLogModelImpl
    implements DailyLog {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a daily log model instance should use the {@link DailyLog} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DailyLogLocalServiceUtil.addDailyLog(this);
        } else {
            DailyLogLocalServiceUtil.updateDailyLog(this);
        }
    }
}
