package ms3.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link ms3.service.service.http.DailyLogServiceSoap}.
 *
 * @author jackt
 * @see ms3.service.service.http.DailyLogServiceSoap
 * @generated
 */
public class DailyLogSoap implements Serializable {
    private long _dailyLogId;
    private long _assignment_id;
    private String _date;
    private String _accomplishments;
    private String _roadblocks;
    private String _plan;
    private String _notes;
    private double _hours;
    private String _section;

    public DailyLogSoap() {
    }

    public static DailyLogSoap toSoapModel(DailyLog model) {
        DailyLogSoap soapModel = new DailyLogSoap();

        soapModel.setDailyLogId(model.getDailyLogId());
        soapModel.setAssignment_id(model.getAssignment_id());
        soapModel.setDate(model.getDate());
        soapModel.setAccomplishments(model.getAccomplishments());
        soapModel.setRoadblocks(model.getRoadblocks());
        soapModel.setPlan(model.getPlan());
        soapModel.setNotes(model.getNotes());
        soapModel.setHours(model.getHours());
        soapModel.setSection(model.getSection());

        return soapModel;
    }

    public static DailyLogSoap[] toSoapModels(DailyLog[] models) {
        DailyLogSoap[] soapModels = new DailyLogSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DailyLogSoap[][] toSoapModels(DailyLog[][] models) {
        DailyLogSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DailyLogSoap[models.length][models[0].length];
        } else {
            soapModels = new DailyLogSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DailyLogSoap[] toSoapModels(List<DailyLog> models) {
        List<DailyLogSoap> soapModels = new ArrayList<DailyLogSoap>(models.size());

        for (DailyLog model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DailyLogSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _dailyLogId;
    }

    public void setPrimaryKey(long pk) {
        setDailyLogId(pk);
    }

    public long getDailyLogId() {
        return _dailyLogId;
    }

    public void setDailyLogId(long dailyLogId) {
        _dailyLogId = dailyLogId;
    }

    public long getAssignment_id() {
        return _assignment_id;
    }

    public void setAssignment_id(long assignment_id) {
        _assignment_id = assignment_id;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String date) {
        _date = date;
    }

    public String getAccomplishments() {
        return _accomplishments;
    }

    public void setAccomplishments(String accomplishments) {
        _accomplishments = accomplishments;
    }

    public String getRoadblocks() {
        return _roadblocks;
    }

    public void setRoadblocks(String roadblocks) {
        _roadblocks = roadblocks;
    }

    public String getPlan() {
        return _plan;
    }

    public void setPlan(String plan) {
        _plan = plan;
    }

    public String getNotes() {
        return _notes;
    }

    public void setNotes(String notes) {
        _notes = notes;
    }

    public double getHours() {
        return _hours;
    }

    public void setHours(double hours) {
        _hours = hours;
    }

    public String getSection() {
        return _section;
    }

    public void setSection(String section) {
        _section = section;
    }
}
