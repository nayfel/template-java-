package ms3.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ms3.service.model.DailyLog;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DailyLog in entity cache.
 *
 * @author jackt
 * @see DailyLog
 * @generated
 */
public class DailyLogCacheModel implements CacheModel<DailyLog>, Externalizable {
    public long dailyLogId;
    public long assignment_id;
    public String date;
    public String accomplishments;
    public String roadblocks;
    public String plan;
    public String notes;
    public double hours;
    public String section;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{dailyLogId=");
        sb.append(dailyLogId);
        sb.append(", assignment_id=");
        sb.append(assignment_id);
        sb.append(", date=");
        sb.append(date);
        sb.append(", accomplishments=");
        sb.append(accomplishments);
        sb.append(", roadblocks=");
        sb.append(roadblocks);
        sb.append(", plan=");
        sb.append(plan);
        sb.append(", notes=");
        sb.append(notes);
        sb.append(", hours=");
        sb.append(hours);
        sb.append(", section=");
        sb.append(section);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public DailyLog toEntityModel() {
        DailyLogImpl dailyLogImpl = new DailyLogImpl();

        dailyLogImpl.setDailyLogId(dailyLogId);
        dailyLogImpl.setAssignment_id(assignment_id);

        if (date == null) {
            dailyLogImpl.setDate(StringPool.BLANK);
        } else {
            dailyLogImpl.setDate(date);
        }

        if (accomplishments == null) {
            dailyLogImpl.setAccomplishments(StringPool.BLANK);
        } else {
            dailyLogImpl.setAccomplishments(accomplishments);
        }

        if (roadblocks == null) {
            dailyLogImpl.setRoadblocks(StringPool.BLANK);
        } else {
            dailyLogImpl.setRoadblocks(roadblocks);
        }

        if (plan == null) {
            dailyLogImpl.setPlan(StringPool.BLANK);
        } else {
            dailyLogImpl.setPlan(plan);
        }

        if (notes == null) {
            dailyLogImpl.setNotes(StringPool.BLANK);
        } else {
            dailyLogImpl.setNotes(notes);
        }

        dailyLogImpl.setHours(hours);

        if (section == null) {
            dailyLogImpl.setSection(StringPool.BLANK);
        } else {
            dailyLogImpl.setSection(section);
        }

        dailyLogImpl.resetOriginalValues();

        return dailyLogImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        dailyLogId = objectInput.readLong();
        assignment_id = objectInput.readLong();
        date = objectInput.readUTF();
        accomplishments = objectInput.readUTF();
        roadblocks = objectInput.readUTF();
        plan = objectInput.readUTF();
        notes = objectInput.readUTF();
        hours = objectInput.readDouble();
        section = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(dailyLogId);
        objectOutput.writeLong(assignment_id);

        if (date == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(date);
        }

        if (accomplishments == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(accomplishments);
        }

        if (roadblocks == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(roadblocks);
        }

        if (plan == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(plan);
        }

        if (notes == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(notes);
        }

        objectOutput.writeDouble(hours);

        if (section == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(section);
        }
    }
}
