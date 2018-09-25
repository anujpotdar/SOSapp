
package com.example.inpota00.sosapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherApi {

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("observation")
    @Expose
    private Observation observation;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Observation getObservation() {
        return observation;
    }

    public void setObservation(Observation observation) {
        this.observation = observation;
    }

}
