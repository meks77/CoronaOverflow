import {AsyncStorage} from "react-native";
import {Constants} from "../services/Constants";

export function setUsername(userID: string) {
    return new Promise((resolve) => {
        AsyncStorage.setItem(Constants.KEY_USERID, userID)
            .then(() => {
                resolve();
            });
    })
}

export function getUsername() {
    return new Promise((resolve) => {
        AsyncStorage.getItem(Constants.KEY_USERID)
            .then((id) => {
                const userID = id ? id : "ANONYMOUS";
                resolve(userID);
            })
            .catch((error) => {
                console.log(error);
                resolve("ANONYMOUS")
            })
    })
}
