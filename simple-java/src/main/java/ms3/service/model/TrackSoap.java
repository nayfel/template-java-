package ms3.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ms3.service.service.http.TrackServiceSoap}.
 *
 * @author jackt
 * @see ms3.service.service.http.TrackServiceSoap
 * @generated
 */
public class TrackSoap implements Serializable {
    private long _trackId;
    private String _title;
    private String _description;
    private String _courseList;
    private String _accreditation;

    public TrackSoap() {
    }

    public static TrackSoap toSoapModel(Track model) {
        TrackSoap soapModel = new TrackSoap();

        soapModel.setTrackId(model.getTrackId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setCourseList(model.getCourseList());
        soapModel.setAccreditation(model.getAccreditation());

        return soapModel;
    }

    public static TrackSoap[] toSoapModels(Track[] models) {
        TrackSoap[] soapModels = new TrackSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static TrackSoap[][] toSoapModels(Track[][] models) {
        TrackSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new TrackSoap[models.length][models[0].length];
        } else {
            soapModels = new TrackSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static TrackSoap[] toSoapModels(List<Track> models) {
        List<TrackSoap> soapModels = new ArrayList<TrackSoap>(models.size());

        for (Track model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new TrackSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _trackId;
    }

    public void setPrimaryKey(long pk) {
        setTrackId(pk);
    }

    public long getTrackId() {
        return _trackId;
    }

    public void setTrackId(long trackId) {
        _trackId = trackId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getCourseList() {
        return _courseList;
    }

    public void setCourseList(String courseList) {
        _courseList = courseList;
    }

    public String getAccreditation() {
        return _accreditation;
    }

    public void setAccreditation(String accreditation) {
        _accreditation = accreditation;
    }
}
