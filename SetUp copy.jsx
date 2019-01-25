Main();

function Main(){
    if(app.documents.length > 0){
        var myDocument = app.activeDocument;
        alert("Finished!");
    }
    else{
        alert("No InDesign documents are open. Please open a document and try again");
    }
}