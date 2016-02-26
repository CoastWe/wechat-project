package com.weibin.wechat.entity.message;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ImageMessage extends BaseMessage{
	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public static void main(String[] args) {
		Image image = new Image();
		image.setMediaId("ssssss");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setImage(image);
		imageMessage.setTouser("id");
		imageMessage.setMsgtype("image");
		
	}
}
