package ms3.service.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import ms3.service.service.AssignmentLocalServiceUtil;
import ms3.service.service.AssignmentServiceUtil;
import ms3.service.service.ClpSerializer;
import ms3.service.service.CourseLocalServiceUtil;
import ms3.service.service.CourseServiceUtil;
import ms3.service.service.DailyLogLocalServiceUtil;
import ms3.service.service.DailyLogServiceUtil;
import ms3.service.service.TrackAssignmentLocalServiceUtil;
import ms3.service.service.TrackAssignmentServiceUtil;
import ms3.service.service.TrackLocalServiceUtil;
import ms3.service.service.TrackServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            AssignmentLocalServiceUtil.clearService();

            AssignmentServiceUtil.clearService();
            CourseLocalServiceUtil.clearService();

            CourseServiceUtil.clearService();
            DailyLogLocalServiceUtil.clearService();

            DailyLogServiceUtil.clearService();
            TrackLocalServiceUtil.clearService();

            TrackServiceUtil.clearService();
            TrackAssignmentLocalServiceUtil.clearService();

            TrackAssignmentServiceUtil.clearService();
        }
    }
}
