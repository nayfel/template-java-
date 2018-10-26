package ms3.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ms3.service.model.TrackAssignment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TrackAssignment in entity cache.
 *
 * @author jackt
 * @see TrackAssignment
 * @generated
 */
public class TrackAssignmentCacheModel implements CacheModel<TrackAssignment>,
    Externalizable {
    public long trackAssignmentId;
    public long trackId;
    public String userScreenName;
    public String assignmentIdList;
    public String dateAssigned;
    public String admin;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{trackAssignmentId=");
        sb.append(trackAssignmentId);
        sb.append(", trackId=");
        sb.append(trackId);
        sb.append(", userScreenName=");
        sb.append(userScreenName);
        sb.append(", assignmentIdList=");
        sb.append(assignmentIdList);
        sb.append(", dateAssigned=");
        sb.append(dateAssigned);
        sb.append(", admin=");
        sb.append(admin);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public TrackAssignment toEntityModel() {
        TrackAssignmentImpl trackAssignmentImpl = new TrackAssignmentImpl();

        trackAssignmentImpl.setTrackAssignmentId(trackAssignmentId);
        trackAssignmentImpl.setTrackId(trackId);

        if (userScreenName == null) {
            trackAssignmentImpl.setUserScreenName(StringPool.BLANK);
        } else {
            trackAssignmentImpl.setUserScreenName(userScreenName);
        }

        if (assignmentIdList == null) {
            trackAssignmentImpl.setAssignmentIdList(StringPool.BLANK);
        } else {
            trackAssignmentImpl.setAssignmentIdList(assignmentIdList);
        }

        if (dateAssigned == null) {
            trackAssignmentImpl.setDateAssigned(StringPool.BLANK);
        } else {
            trackAssignmentImpl.setDateAssigned(dateAssigned);
        }

        if (admin == null) {
            trackAssignmentImpl.setAdmin(StringPool.BLANK);
        } else {
            trackAssignmentImpl.setAdmin(admin);
        }

        trackAssignmentImpl.resetOriginalValues();

        return trackAssignmentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        trackAssignmentId = objectInput.readLong();
        trackId = objectInput.readLong();
        userScreenName = objectInput.readUTF();
        assignmentIdList = objectInput.readUTF();
        dateAssigned = objectInput.readUTF();
        admin = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(trackAssignmentId);
        objectOutput.writeLong(trackId);

        if (userScreenName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userScreenName);
        }

        if (assignmentIdList == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(assignmentIdList);
        }

        if (dateAssigned == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(dateAssigned);
        }

        if (admin == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(admin);
        }
    }
}
