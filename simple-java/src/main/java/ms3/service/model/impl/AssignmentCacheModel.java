package ms3.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ms3.service.model.Assignment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Assignment in entity cache.
 *
 * @author jackt
 * @see Assignment
 * @generated
 */
public class AssignmentCacheModel implements CacheModel<Assignment>,
    Externalizable {
    public long assignmentId;
    public String courses_title;
    public String ms3employeedb_uid;
    public String assignedDate;
    public String startDate;
    public String endDate;
    public String status;
    public String cost;
    public boolean certification;
    public double hoursSpent;
    public String currentSection;
    public String notes;
    public String admin;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{assignmentId=");
        sb.append(assignmentId);
        sb.append(", courses_title=");
        sb.append(courses_title);
        sb.append(", ms3employeedb_uid=");
        sb.append(ms3employeedb_uid);
        sb.append(", assignedDate=");
        sb.append(assignedDate);
        sb.append(", startDate=");
        sb.append(startDate);
        sb.append(", endDate=");
        sb.append(endDate);
        sb.append(", status=");
        sb.append(status);
        sb.append(", cost=");
        sb.append(cost);
        sb.append(", certification=");
        sb.append(certification);
        sb.append(", hoursSpent=");
        sb.append(hoursSpent);
        sb.append(", currentSection=");
        sb.append(currentSection);
        sb.append(", notes=");
        sb.append(notes);
        sb.append(", admin=");
        sb.append(admin);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Assignment toEntityModel() {
        AssignmentImpl assignmentImpl = new AssignmentImpl();

        assignmentImpl.setAssignmentId(assignmentId);

        if (courses_title == null) {
            assignmentImpl.setCourses_title(StringPool.BLANK);
        } else {
            assignmentImpl.setCourses_title(courses_title);
        }

        if (ms3employeedb_uid == null) {
            assignmentImpl.setMs3employeedb_uid(StringPool.BLANK);
        } else {
            assignmentImpl.setMs3employeedb_uid(ms3employeedb_uid);
        }

        if (assignedDate == null) {
            assignmentImpl.setAssignedDate(StringPool.BLANK);
        } else {
            assignmentImpl.setAssignedDate(assignedDate);
        }

        if (startDate == null) {
            assignmentImpl.setStartDate(StringPool.BLANK);
        } else {
            assignmentImpl.setStartDate(startDate);
        }

        if (endDate == null) {
            assignmentImpl.setEndDate(StringPool.BLANK);
        } else {
            assignmentImpl.setEndDate(endDate);
        }

        if (status == null) {
            assignmentImpl.setStatus(StringPool.BLANK);
        } else {
            assignmentImpl.setStatus(status);
        }

        if (cost == null) {
            assignmentImpl.setCost(StringPool.BLANK);
        } else {
            assignmentImpl.setCost(cost);
        }

        assignmentImpl.setCertification(certification);
        assignmentImpl.setHoursSpent(hoursSpent);

        if (currentSection == null) {
            assignmentImpl.setCurrentSection(StringPool.BLANK);
        } else {
            assignmentImpl.setCurrentSection(currentSection);
        }

        if (notes == null) {
            assignmentImpl.setNotes(StringPool.BLANK);
        } else {
            assignmentImpl.setNotes(notes);
        }

        if (admin == null) {
            assignmentImpl.setAdmin(StringPool.BLANK);
        } else {
            assignmentImpl.setAdmin(admin);
        }

        assignmentImpl.resetOriginalValues();

        return assignmentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        assignmentId = objectInput.readLong();
        courses_title = objectInput.readUTF();
        ms3employeedb_uid = objectInput.readUTF();
        assignedDate = objectInput.readUTF();
        startDate = objectInput.readUTF();
        endDate = objectInput.readUTF();
        status = objectInput.readUTF();
        cost = objectInput.readUTF();
        certification = objectInput.readBoolean();
        hoursSpent = objectInput.readDouble();
        currentSection = objectInput.readUTF();
        notes = objectInput.readUTF();
        admin = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(assignmentId);

        if (courses_title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(courses_title);
        }

        if (ms3employeedb_uid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ms3employeedb_uid);
        }

        if (assignedDate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(assignedDate);
        }

        if (startDate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(startDate);
        }

        if (endDate == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(endDate);
        }

        if (status == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(status);
        }

        if (cost == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(cost);
        }

        objectOutput.writeBoolean(certification);
        objectOutput.writeDouble(hoursSpent);

        if (currentSection == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(currentSection);
        }

        if (notes == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(notes);
        }

        if (admin == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(admin);
        }
    }
}
