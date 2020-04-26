import {Label} from "../interfaces/Label";
import {Posting} from "../interfaces/Posting";

export function searchLabel(displayListInput: [], value: string): [] {
    const displayList: [] = []
    displayListInput.forEach((item: Label) => {
        if (item.label.includes(value)) {
            displayList.push(item as never);
        }
    })
    return displayList;
}

export function searchPosting(displayListInput: [], value: string): [] {
    const displayList: [] = []
    displayListInput.forEach((item: Posting) => {
        if (item.title.includes(value) || item.text.includes(value) || item.userID.includes(value)) {
            displayList.push(item as never);
        }
    })
    return displayList;
}
