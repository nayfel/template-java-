package ms3.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ms3.service.service.http.TrackAssignmentServiceSoap}.
 *
 * @author jackt
 * @see ms3.service.service.http.TrackAssignmentServiceSoap
 * @generated
 */
public class TrackAssignmentSoap implements Serializable {
    private long _trackAssignmentId;
    private long _trackId;
    private String _userScreenName;
    private String _assignmentIdList;
    private String _dateAssigned;
    private String _admin;

    public TrackAssignmentSoap() {
    }

    public static TrackAssignmentSoap toSoapModel(TrackAssignment model) {
        TrackAssignmentSoap soapModel = new TrackAssignmentSoap();

        soapModel.setTrackAssignmentId(model.getTrackAssignmentId());
        soapModel.setTrackId(model.getTrackId());
        soapModel.setUserScreenName(model.getUserScreenName());
        soapModel.setAssignmentIdList(model.getAssignmentIdList());
        soapModel.setDateAssigned(model.getDateAssigned());
        soapModel.setAdmin(model.getAdmin());

        return soapModel;
    }

    public static TrackAssignmentSoap[] toSoapModels(TrackAssignment[] models) {
        TrackAssignmentSoap[] soapModels = new TrackAssignmentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static TrackAssignmentSoap[][] toSoapModels(
        TrackAssignment[][] models) {
        TrackAssignmentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new TrackAssignmentSoap[models.length][models[0].length];
        } else {
            soapModels = new TrackAssignmentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static TrackAssignmentSoap[] toSoapModels(
        List<TrackAssignment> models) {
        List<TrackAssignmentSoap> soapModels = new ArrayList<TrackAssignmentSoap>(models.size());

        for (TrackAssignment model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new TrackAssignmentSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _trackAssignmentId;
    }

    public void setPrimaryKey(long pk) {
        setTrackAssignmentId(pk);
    }

    public long getTrackAssignmentId() {
        return _trackAssignmentId;
    }

    public void setTrackAssignmentId(long trackAssignmentId) {
        _trackAssignmentId = trackAssignmentId;
    }

    public long getTrackId() {
        return _trackId;
    }

    public void setTrackId(long trackId) {
        _trackId = trackId;
    }

    public String getUserScreenName() {
        return _userScreenName;
    }

    public void setUserScreenName(String userScreenName) {
        _userScreenName = userScreenName;
    }

    public String getAssignmentIdList() {
        return _assignmentIdList;
    }

    public void setAssignmentIdList(String assignmentIdList) {
        _assignmentIdList = assignmentIdList;
    }

    public String getDateAssigned() {
        return _dateAssigned;
    }

    public void setDateAssigned(String dateAssigned) {
        _dateAssigned = dateAssigned;
    }

    public String getAdmin() {
        return _admin;
    }

    public void setAdmin(String admin) {
        _admin = admin;
    }
}
