import {AsyncStorage} from "react-native";
import {Constants} from "../services/Constants";
import {Routes} from "../services/api/Routes";

export function setURL(url: string) {
    return new Promise((resolve) => {
        AsyncStorage.setItem(Constants.KEY_URL, url)
            .then(() => {
                resolve();
            });
    })
}

export function getURL() {
    return new Promise((resolve) => {
        AsyncStorage.getItem(Constants.KEY_URL)
            .then((data) => {
                console.log(data)
                const url = data ? data : Routes.BASEURL;
                resolve(url);
            })
            .catch((error) => {
                console.log(error);
                resolve(Routes.BASEURL)
            })
    })
}
