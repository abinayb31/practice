package com.example.bandaab.musicapp.Model.Search;

import android.os.Parcel;
import android.os.Parcelable;

public class MusicResponse  implements Parcelable {

    private String wrapperType;
    private String kind;
    private Integer artistId;
    private Integer collectionId;
    private Integer trackId;
    private String artistName;
    private String collectionName;
    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;
    private Integer collectionArtistId;
    private String collectionArtistName;
    private String collectionArtistViewUrl;
    private String artistViewUrl;
    private String collectionViewUrl;
    private String trackViewUrl;
    private String previewUrl;
    private String artworkUrl30;
    private String artworkUrl60;
    private String artworkUrl100;
    private Float collectionPrice;
    private Float trackPrice;
    private String releaseDate;
    private String collectionExplicitness;
    private String trackExplicitness;
    private Integer discCount;
    private Integer discNumber;
    private Integer trackCount;
    private Integer trackNumber;
    private Integer trackTimeMillis;
    private String country;
    private String currency;
    private String primaryGenreName;
    private String radioStationUrl;
    private Boolean isStreamable;

    protected MusicResponse(Parcel in) {
        wrapperType = in.readString();
        kind = in.readString();
        if (in.readByte() == 0) {
            artistId = null;
        } else {
            artistId = in.readInt();
        }
        if (in.readByte() == 0) {
            collectionId = null;
        } else {
            collectionId = in.readInt();
        }
        if (in.readByte() == 0) {
            trackId = null;
        } else {
            trackId = in.readInt();
        }
        artistName = in.readString();
        collectionName = in.readString();
        trackName = in.readString();
        collectionCensoredName = in.readString();
        trackCensoredName = in.readString();
        if (in.readByte() == 0) {
            collectionArtistId = null;
        } else {
            collectionArtistId = in.readInt();
        }
        collectionArtistName = in.readString();
        collectionArtistViewUrl = in.readString();
        artistViewUrl = in.readString();
        collectionViewUrl = in.readString();
        trackViewUrl = in.readString();
        previewUrl = in.readString();
        artworkUrl30 = in.readString();
        artworkUrl60 = in.readString();
        artworkUrl100 = in.readString();
        if (in.readByte() == 0) {
            collectionPrice = null;
        } else {
            collectionPrice = in.readFloat();
        }
        if (in.readByte() == 0) {
            trackPrice = null;
        } else {
            trackPrice = in.readFloat();
        }
        releaseDate = in.readString();
        collectionExplicitness = in.readString();
        trackExplicitness = in.readString();
        if (in.readByte() == 0) {
            discCount = null;
        } else {
            discCount = in.readInt();
        }
        if (in.readByte() == 0) {
            discNumber = null;
        } else {
            discNumber = in.readInt();
        }
        if (in.readByte() == 0) {
            trackCount = null;
        } else {
            trackCount = in.readInt();
        }
        if (in.readByte() == 0) {
            trackNumber = null;
        } else {
            trackNumber = in.readInt();
        }
        if (in.readByte() == 0) {
            trackTimeMillis = null;
        } else {
            trackTimeMillis = in.readInt();
        }
        country = in.readString();
        currency = in.readString();
        primaryGenreName = in.readString();
        radioStationUrl = in.readString();
        byte tmpIsStreamable = in.readByte();
        isStreamable = tmpIsStreamable == 0 ? null : tmpIsStreamable == 1;
    }

    public static final Creator<MusicResponse> CREATOR = new Creator<MusicResponse>() {
        @Override
        public MusicResponse createFromParcel(Parcel in) {
            return new MusicResponse(in);
        }

        @Override
        public MusicResponse[] newArray(int size) {
            return new MusicResponse[size];
        }
    };

    /**
     * @return The wrapperType
     */
    public String getWrapperType() {
        return wrapperType;
    }

    /**
     * @param wrapperType The wrapperType
     */
    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    /**
     * @return The kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind The kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return The artistId
     */
    public Integer getArtistId() {
        return artistId;
    }

    /**
     * @param artistId The artistId
     */
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    /**
     * @return The collectionId
     */
    public Integer getCollectionId() {
        return collectionId;
    }

    /**
     * @param collectionId The collectionId
     */
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * @return The trackId
     */
    public Integer getTrackId() {
        return trackId;
    }

    /**
     * @param trackId The trackId
     */
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    /**
     * @return The artistName
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * @param artistName The artistName
     */
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    /**
     * @return The collectionName
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * @param collectionName The collectionName
     */
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    /**
     * @return The trackName
     */
    public String getTrackName() {
        return trackName;
    }

    /**
     * @param trackName The trackName
     */
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    /**
     * @return The collectionCensoredName
     */
    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    /**
     * @param collectionCensoredName The collectionCensoredName
     */
    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    /**
     * @return The trackCensoredName
     */
    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    /**
     * @param trackCensoredName The trackCensoredName
     */
    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    /**
     * @return The collectionArtistId
     */
    public Integer getCollectionArtistId() {
        return collectionArtistId;
    }

    /**
     * @param collectionArtistId The collectionArtistId
     */
    public void setCollectionArtistId(Integer collectionArtistId) {
        this.collectionArtistId = collectionArtistId;
    }

    /**
     * @return The collectionArtistName
     */
    public String getCollectionArtistName() {
        return collectionArtistName;
    }

    /**
     * @param collectionArtistName The collectionArtistName
     */
    public void setCollectionArtistName(String collectionArtistName) {
        this.collectionArtistName = collectionArtistName;
    }

    /**
     * @return The collectionArtistViewUrl
     */
    public String getCollectionArtistViewUrl() {
        return collectionArtistViewUrl;
    }

    /**
     * @param collectionArtistViewUrl The collectionArtistViewUrl
     */
    public void setCollectionArtistViewUrl(String collectionArtistViewUrl) {
        this.collectionArtistViewUrl = collectionArtistViewUrl;
    }

    /**
     * @return The artistViewUrl
     */
    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    /**
     * @param artistViewUrl The artistViewUrl
     */
    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    /**
     * @return The collectionViewUrl
     */
    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    /**
     * @param collectionViewUrl The collectionViewUrl
     */
    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    /**
     * @return The trackViewUrl
     */
    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    /**
     * @param trackViewUrl The trackViewUrl
     */
    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    /**
     * @return The previewUrl
     */
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * @param previewUrl The previewUrl
     */
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    /**
     * @return The artworkUrl30
     */
    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    /**
     * @param artworkUrl30 The artworkUrl30
     */
    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    /**
     * @return The artworkUrl60
     */
    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    /**
     * @param artworkUrl60 The artworkUrl60
     */
    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    /**
     * @return The artworkUrl100
     */
    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    /**
     * @param artworkUrl100 The artworkUrl100
     */
    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    /**
     * @return The collectionPrice
     */
    public Float getCollectionPrice() {
        return collectionPrice;
    }

    /**
     * @param collectionPrice The collectionPrice
     */
    public void setCollectionPrice(Float collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    /**
     * @return The trackPrice
     */
    public Float getTrackPrice() {
        return trackPrice;
    }

    /**
     * @param trackPrice The trackPrice
     */
    public void setTrackPrice(Float trackPrice) {
        this.trackPrice = trackPrice;
    }

    /**
     * @return The releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate The releaseDate
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return The collectionExplicitness
     */
    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    /**
     * @param collectionExplicitness The collectionExplicitness
     */
    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    /**
     * @return The trackExplicitness
     */
    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    /**
     * @param trackExplicitness The trackExplicitness
     */
    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    /**
     * @return The discCount
     */
    public Integer getDiscCount() {
        return discCount;
    }

    /**
     * @param discCount The discCount
     */
    public void setDiscCount(Integer discCount) {
        this.discCount = discCount;
    }

    /**
     * @return The discNumber
     */
    public Integer getDiscNumber() {
        return discNumber;
    }

    /**
     * @param discNumber The discNumber
     */
    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    /**
     * @return The trackCount
     */
    public Integer getTrackCount() {
        return trackCount;
    }

    /**
     * @param trackCount The trackCount
     */
    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    /**
     * @return The trackNumber
     */
    public Integer getTrackNumber() {
        return trackNumber;
    }

    /**
     * @param trackNumber The trackNumber
     */
    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    /**
     * @return The trackTimeMillis
     */
    public Integer getTrackTimeMillis() {
        return trackTimeMillis;
    }

    /**
     * @param trackTimeMillis The trackTimeMillis
     */
    public void setTrackTimeMillis(Integer trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return The primaryGenreName
     */
    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    /**
     * @param primaryGenreName The primaryGenreName
     */
    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    /**
     * @return The radioStationUrl
     */
    public String getRadioStationUrl() {
        return radioStationUrl;
    }

    /**
     * @param radioStationUrl The radioStationUrl
     */
    public void setRadioStationUrl(String radioStationUrl) {
        this.radioStationUrl = radioStationUrl;
    }

    /**
     * @return The isStreamable
     */
    public Boolean getIsStreamable() {
        return isStreamable;
    }

    /**
     * @param isStreamable The isStreamable
     */
    public void setIsStreamable(Boolean isStreamable) {
        this.isStreamable = isStreamable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(wrapperType);
        dest.writeString(kind);
        if (artistId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(artistId);
        }
        if (collectionId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(collectionId);
        }
        if (trackId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trackId);
        }
        dest.writeString(artistName);
        dest.writeString(collectionName);
        dest.writeString(trackName);
        dest.writeString(collectionCensoredName);
        dest.writeString(trackCensoredName);
        if (collectionArtistId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(collectionArtistId);
        }
        dest.writeString(collectionArtistName);
        dest.writeString(collectionArtistViewUrl);
        dest.writeString(artistViewUrl);
        dest.writeString(collectionViewUrl);
        dest.writeString(trackViewUrl);
        dest.writeString(previewUrl);
        dest.writeString(artworkUrl30);
        dest.writeString(artworkUrl60);
        dest.writeString(artworkUrl100);
        if (collectionPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(collectionPrice);
        }
        if (trackPrice == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(trackPrice);
        }
        dest.writeString(releaseDate);
        dest.writeString(collectionExplicitness);
        dest.writeString(trackExplicitness);
        if (discCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(discCount);
        }
        if (discNumber == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(discNumber);
        }
        if (trackCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trackCount);
        }
        if (trackNumber == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trackNumber);
        }
        if (trackTimeMillis == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trackTimeMillis);
        }
        dest.writeString(country);
        dest.writeString(currency);
        dest.writeString(primaryGenreName);
        dest.writeString(radioStationUrl);
        dest.writeByte((byte) (isStreamable == null ? 0 : isStreamable ? 1 : 2));
    }
}
