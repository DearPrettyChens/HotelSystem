package util;

public enum ImageType {
	userImage, hotelImage;
	public String getString() {
		String string = null;
		switch (this) {
		case userImage:
			string = "userImage";

			break;
		case hotelImage:
			string = "hotelImage";
			break;
		default:
			break;
		}
		return string;
	}
}
