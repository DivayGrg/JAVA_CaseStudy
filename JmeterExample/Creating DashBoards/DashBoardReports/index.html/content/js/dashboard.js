/*
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
var showControllersOnly = false;
var seriesFilter = "";
var filtersOnlySampleSeries = true;

/*
 * Add header in statistics table to group metrics by category
 * format
 *
 */
function summaryTableHeader(header) {
    var newRow = header.insertRow(-1);
    newRow.className = "tablesorter-no-sort";
    var cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Requests";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 3;
    cell.innerHTML = "Executions";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 7;
    cell.innerHTML = "Response Times (ms)";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 1;
    cell.innerHTML = "Throughput";
    newRow.appendChild(cell);

    cell = document.createElement('th');
    cell.setAttribute("data-sorter", false);
    cell.colSpan = 2;
    cell.innerHTML = "Network (KB/sec)";
    newRow.appendChild(cell);
}

/*
 * Populates the table identified by id parameter with the specified data and
 * format
 *
 */
function createTable(table, info, formatter, defaultSorts, seriesIndex, headerCreator) {
    var tableRef = table[0];

    // Create header and populate it with data.titles array
    var header = tableRef.createTHead();

    // Call callback is available
    if(headerCreator) {
        headerCreator(header);
    }

    var newRow = header.insertRow(-1);
    for (var index = 0; index < info.titles.length; index++) {
        var cell = document.createElement('th');
        cell.innerHTML = info.titles[index];
        newRow.appendChild(cell);
    }

    var tBody;

    // Create overall body if defined
    if(info.overall){
        tBody = document.createElement('tbody');
        tBody.className = "tablesorter-no-sort";
        tableRef.appendChild(tBody);
        var newRow = tBody.insertRow(-1);
        var data = info.overall.data;
        for(var index=0;index < data.length; index++){
            var cell = newRow.insertCell(-1);
            cell.innerHTML = formatter ? formatter(index, data[index]): data[index];
        }
    }

    // Create regular body
    tBody = document.createElement('tbody');
    tableRef.appendChild(tBody);

    var regexp;
    if(seriesFilter) {
        regexp = new RegExp(seriesFilter, 'i');
    }
    // Populate body with data.items array
    for(var index=0; index < info.items.length; index++){
        var item = info.items[index];
        if((!regexp || filtersOnlySampleSeries && !info.supportsControllersDiscrimination || regexp.test(item.data[seriesIndex]))
                &&
                (!showControllersOnly || !info.supportsControllersDiscrimination || item.isController)){
            if(item.data.length > 0) {
                var newRow = tBody.insertRow(-1);
                for(var col=0; col < item.data.length; col++){
                    var cell = newRow.insertCell(-1);
                    cell.innerHTML = formatter ? formatter(col, item.data[col]) : item.data[col];
                }
            }
        }
    }

    // Add support of columns sort
    table.tablesorter({sortList : defaultSorts});
}

$(document).ready(function() {

    // Customize table sorter default options
    $.extend( $.tablesorter.defaults, {
        theme: 'blue',
        cssInfoBlock: "tablesorter-no-sort",
        widthFixed: true,
        widgets: ['zebra']
    });

    var data = {"OkPercent": 43.03365999147848, "KoPercent": 56.96634000852152};
    var dataset = [
        {
            "label" : "FAIL",
            "data" : data.KoPercent,
            "color" : "#FF6347"
        },
        {
            "label" : "PASS",
            "data" : data.OkPercent,
            "color" : "#9ACD32"
        }];
    $.plot($("#flot-requests-summary"), dataset, {
        series : {
            pie : {
                show : true,
                radius : 1,
                label : {
                    show : true,
                    radius : 3 / 4,
                    formatter : function(label, series) {
                        return '<div style="font-size:8pt;text-align:center;padding:2px;color:white;">'
                            + label
                            + '<br/>'
                            + Math.round10(series.percent, -2)
                            + '%</div>';
                    },
                    background : {
                        opacity : 0.5,
                        color : '#000'
                    }
                }
            }
        },
        legend : {
            show : true
        }
    });

    // Creates APDEX table
    createTable($("#apdexTable"), {"supportsControllersDiscrimination": true, "overall": {"data": [0.17806419542678598, 500, 1500, "Total"], "isController": false}, "titles": ["Apdex", "T (Toleration threshold)", "F (Frustration threshold)", "Label"], "items": [{"data": [0.0, 500, 1500, "JAVA"], "isController": false}, {"data": [0.0, 500, 1500, "JAVASCRIPT"], "isController": false}, {"data": [0.5575, 500, 1500, "FROMULAS-0"], "isController": false}, {"data": [0.0, 500, 1500, "NEW"], "isController": false}, {"data": [0.525, 500, 1500, "FROMULAS-1"], "isController": false}, {"data": [0.0, 500, 1500, "CATS"], "isController": false}, {"data": [0.0, 500, 1500, "Practice test login excercise"], "isController": false}, {"data": [0.0, 500, 1500, "Practice Test Exception"], "isController": false}, {"data": [0.0, 500, 1500, "VITAMINS&SUPPLEMENTS"], "isController": false}, {"data": [0.22125, 500, 1500, "CURRENCYCONVERTER"], "isController": false}, {"data": [0.0, 500, 1500, "Practice"], "isController": false}, {"data": [0.0, 500, 1500, "Courses"], "isController": false}, {"data": [0.45125, 500, 1500, "INDEX-1"], "isController": false}, {"data": [0.5325, 500, 1500, "INDEX-0"], "isController": false}, {"data": [0.0, 500, 1500, "DOGS"], "isController": false}, {"data": [0.5186046511627908, 500, 1500, "HOME-0"], "isController": false}, {"data": [0.3616279069767442, 500, 1500, "HOME-1"], "isController": false}, {"data": [0.20625, 500, 1500, "INDEX"], "isController": false}, {"data": [0.0, 500, 1500, "Home"], "isController": false}, {"data": [0.0, 500, 1500, "OFFERS"], "isController": false}, {"data": [0.5675, 500, 1500, "CURRENCYCONVERTER-1"], "isController": false}, {"data": [0.56, 500, 1500, "CURRENCYCONVERTER-0"], "isController": false}, {"data": [0.0, 500, 1500, "DATA sCIENCE-0"], "isController": false}, {"data": [0.0, 500, 1500, "DATA sCIENCE-1"], "isController": false}, {"data": [0.0, 500, 1500, "DATA sCIENCE"], "isController": false}, {"data": [0.0, 500, 1500, "OFFERS-1"], "isController": false}, {"data": [0.0, 500, 1500, "OFFERS-0"], "isController": false}, {"data": [0.0, 500, 1500, "TRENDING"], "isController": false}, {"data": [0.24, 500, 1500, "CONVERTORS"], "isController": false}, {"data": [0.5325, 500, 1500, "CONVERTORS-0"], "isController": false}, {"data": [0.5275, 500, 1500, "CONVERTORS-1"], "isController": false}, {"data": [0.22375, 500, 1500, "FROMULAS"], "isController": false}, {"data": [0.0, 500, 1500, "FISH"], "isController": false}, {"data": [0.0, 500, 1500, "C programming"], "isController": false}, {"data": [0.0, 500, 1500, "REPTILES"], "isController": false}, {"data": [0.0, 500, 1500, "HOme"], "isController": false}, {"data": [0.059166666666666666, 500, 1500, "HOME"], "isController": false}]}, function(index, item){
        switch(index){
            case 0:
                item = item.toFixed(3);
                break;
            case 1:
            case 2:
                item = formatDuration(item);
                break;
        }
        return item;
    }, [[0, 0]], 3);

    // Create statistics table
    createTable($("#statisticsTable"), {"supportsControllersDiscrimination": true, "overall": {"data": ["Total", 14082, 8022, 56.96634000852152, 2485.707072858958, 0, 239449, 1.0, 2134.0, 5036.5499999999665, 59393.09000000005, 26.628041320548142, 279.9540461771591, 2.0791025061171506], "isController": false}, "titles": ["Label", "#Samples", "FAIL", "Error %", "Average", "Min", "Max", "Median", "90th pct", "95th pct", "99th pct", "Transactions/s", "Received", "Sent"], "items": [{"data": ["JAVA", 400, 400, 100.0, 0.44000000000000117, 0, 31, 0.0, 1.0, 1.0, 11.970000000000027, 2.8431909131618416, 6.008462046955297, 0.0], "isController": false}, {"data": ["JAVASCRIPT", 400, 400, 100.0, 0.19000000000000017, 0, 5, 0.0, 1.0, 1.0, 2.0, 2.8433323855558714, 6.0087610179129936, 0.0], "isController": false}, {"data": ["FROMULAS-0", 400, 0, 0.0, 895.4150000000005, 294, 3638, 768.5, 1400.7, 1854.4499999999996, 3463.6100000000006, 2.0376974019358127, 0.7561767702496179, 0.27660150280183393], "isController": false}, {"data": ["NEW", 400, 400, 100.0, 330.8175, 0, 11863, 0.0, 1.0, 1.0, 11856.99, 2.843251542463962, 6.0357454472434675, 0.0], "isController": false}, {"data": ["FROMULAS-1", 400, 0, 0.0, 998.4825000000004, 303, 8650, 795.0, 1821.800000000002, 2709.7999999999997, 4219.880000000001, 2.0699219639419595, 46.817834577011446, 0.28906136801142596], "isController": false}, {"data": ["CATS", 400, 400, 100.0, 0.1575, 0, 1, 0.0, 1.0, 1.0, 1.0, 9.061459348028, 19.18480846340303, 0.0], "isController": false}, {"data": ["Practice test login excercise", 400, 400, 100.0, 3067.23, 0, 87714, 0.0, 16513.000000000175, 27963.75, 79814.44000000035, 1.7930304904834908, 3.9865511506773172, 0.0], "isController": false}, {"data": ["Practice Test Exception", 400, 400, 100.0, 2034.4750000000026, 0, 28263, 0.0, 14320.000000000542, 18017.0, 25492.480000000003, 2.0814903470885158, 4.617900166519228, 0.0], "isController": false}, {"data": ["VITAMINS&SUPPLEMENTS", 400, 400, 100.0, 0.22, 0, 18, 0.0, 1.0, 1.0, 1.0, 2.8433121743519023, 6.019824994135668, 0.0], "isController": false}, {"data": ["CURRENCYCONVERTER", 400, 0, 0.0, 1811.2650000000003, 673, 10762, 1582.0, 2714.800000000002, 3578.6, 6497.420000000004, 2.0830295581894305, 41.04829438935989, 0.6143309829816486], "isController": false}, {"data": ["Practice", 400, 392, 98.0, 2746.8024999999952, 0, 32449, 0.0, 16514.700000000004, 22035.499999999953, 28491.99, 1.4987841113896352, 6.907605433607611, 0.004010418423054297], "isController": false}, {"data": ["Courses", 400, 394, 98.5, 2972.894999999999, 0, 70030, 0.0, 16881.800000000025, 22937.0, 39983.85000000001, 1.5493366902294954, 6.992074023191633, 0.003086569187566573], "isController": false}, {"data": ["INDEX-1", 400, 0, 0.0, 2417.120000000001, 298, 48008, 844.0, 2638.4000000000015, 13734.349999999948, 47590.11, 1.5287714792392835, 72.02991949107196, 0.20005408029107807], "isController": false}, {"data": ["INDEX-0", 400, 0, 0.0, 6105.927499999994, 302, 162195, 774.5, 2177.1000000000004, 60297.89999999932, 159998.43, 0.9462416464604648, 0.3428277840203442, 0.1201283340233012], "isController": false}, {"data": ["DOGS", 400, 397, 99.25, 854.3524999999997, 0, 74900, 0.0, 1.0, 1.0, 64077.92000000001, 4.074564530915758, 8.723278576067026, 0.005222525338698177], "isController": false}, {"data": ["HOME-0", 430, 0, 0.0, 2983.188372093024, 297, 56089, 775.5, 2988.8000000000043, 23867.749999999996, 46313.73999999999, 0.822524154473862, 0.293072798408894, 0.09719279559700908], "isController": false}, {"data": ["HOME-1", 430, 41, 9.534883720930232, 10667.02325581395, 296, 186963, 1168.5, 31650.400000000005, 35972.7, 183005.91, 0.8247770704302075, 34.772645869856895, 0.09108099802341217], "isController": false}, {"data": ["INDEX", 400, 0, 0.0, 8523.187499999998, 649, 209978, 1687.5, 4399.500000000002, 77293.7499999992, 207781.71, 0.9448781697709852, 44.861412947193124, 0.24360140314408213], "isController": false}, {"data": ["Home", 400, 392, 98.0, 2716.0150000000003, 0, 30328, 0.0, 17004.9, 18509.1, 27963.0, 1.464541616780718, 7.010577651827199, 0.003661354041951795], "isController": false}, {"data": ["OFFERS", 400, 400, 100.0, 3307.252500000002, 0, 120328, 0.0, 1.0, 10098.14999999988, 118649.02000000002, 2.622263012980202, 5.6507399186279015, 0.005608160154713518], "isController": false}, {"data": ["CURRENCYCONVERTER-1", 400, 0, 0.0, 910.8250000000003, 299, 8972, 757.0, 1368.3000000000009, 1935.0499999999997, 4061.850000000005, 2.0931120913852737, 40.44979997697577, 0.312740380841745], "isController": false}, {"data": ["CURRENCYCONVERTER-0", 400, 0, 0.0, 900.3449999999998, 300, 5421, 773.0, 1429.0, 2044.3999999999996, 3377.1400000000026, 2.0887619385799554, 0.7955245664513501, 0.30393118051602863], "isController": false}, {"data": ["DATA sCIENCE-0", 5, 0, 0.0, 106280.0, 98643, 108476, 108104.0, 108476.0, 108476.0, 108476.0, 0.0381927204674789, 0.016821207940266585, 0.0060422077302066226], "isController": false}, {"data": ["DATA sCIENCE-1", 5, 5, 100.0, 10681.2, 8694, 11853, 10798.0, 11853.0, 11853.0, 11853.0, 0.12205839273508445, 0.34109599282296654, 0.0], "isController": false}, {"data": ["DATA sCIENCE", 400, 400, 100.0, 2928.7000000000007, 0, 120328, 0.0, 1.0, 10093.949999999879, 116375.62000000005, 2.622263012980202, 5.633941046200997, 0.005185627540317294], "isController": false}, {"data": ["OFFERS-1", 6, 6, 100.0, 10367.166666666668, 8694, 11850, 10799.0, 11850.0, 11850.0, 11850.0, 0.5063291139240507, 1.384164029535865, 0.0], "isController": false}, {"data": ["OFFERS-0", 6, 0, 0.0, 107847.5, 106958, 108478, 107988.0, 108478.0, 108478.0, 108478.0, 0.053746584852420835, 0.022096984592645676, 0.007663087293411564], "isController": false}, {"data": ["TRENDING", 400, 400, 100.0, 0.28750000000000026, 0, 22, 0.0, 1.0, 1.0, 4.0, 2.843251542463962, 6.019696625060419, 0.0], "isController": false}, {"data": ["CONVERTORS", 400, 0, 0.0, 2581.397500000002, 621, 26104, 1574.0, 3840.800000000002, 9458.549999999985, 24309.870000000003, 1.8569757293272176, 44.68529193979685, 0.5367820467586488], "isController": false}, {"data": ["CONVERTORS-0", 400, 0, 0.0, 1382.105000000001, 298, 14193, 771.0, 1831.900000000001, 7423.899999999958, 13841.6, 1.8625442354255914, 0.7039107608493202, 0.26555806481653943], "isController": false}, {"data": ["CONVERTORS-1", 400, 0, 0.0, 1199.2025000000003, 306, 12202, 759.5, 2356.0000000000023, 3770.7499999999977, 10802.500000000005, 1.9852200368258317, 47.02102223942746, 0.29080371633190893], "isController": false}, {"data": ["FROMULAS", 400, 0, 0.0, 1893.9824999999992, 615, 10306, 1595.5, 3185.5, 3819.1, 6515.76, 2.033439919475779, 46.74727455505793, 0.5599902903243845], "isController": false}, {"data": ["FISH", 400, 392, 98.0, 970.8499999999998, 0, 73441, 0.0, 1.0, 6805.299999999918, 23562.950000000004, 3.6191234483008214, 7.847030113369042, 0.012370050848684448], "isController": false}, {"data": ["C programming", 400, 400, 100.0, 242.87499999999994, 0, 11870, 0.0, 1.0, 2.0, 11855.0, 2.843170703969066, 6.022718488783692, 0.0], "isController": false}, {"data": ["REPTILES", 400, 400, 100.0, 104.83500000000001, 0, 11864, 0.0, 1.0, 1.0, 8130.880000000075, 9.061459348028, 19.204807387354734, 0.0], "isController": false}, {"data": ["HOme", 400, 392, 98.0, 2192.3449999999984, 0, 63980, 0.0, 1.0, 8268.8499999999, 63673.950000000004, 3.3433913690351806, 7.30051054631015, 0.009468588838087915], "isController": false}, {"data": ["HOME", 1200, 811, 67.58333333333333, 5170.036666666664, 0, 239449, 0.0, 3134.100000000001, 32238.550000001, 190377.7900000004, 2.2925876819263853, 38.03810249383389, 0.18779330495141622], "isController": false}]}, function(index, item){
        switch(index){
            // Errors pct
            case 3:
                item = item.toFixed(2) + '%';
                break;
            // Mean
            case 4:
            // Mean
            case 7:
            // Median
            case 8:
            // Percentile 1
            case 9:
            // Percentile 2
            case 10:
            // Percentile 3
            case 11:
            // Throughput
            case 12:
            // Kbytes/s
            case 13:
            // Sent Kbytes/s
                item = item.toFixed(2);
                break;
        }
        return item;
    }, [[0, 0]], 0, summaryTableHeader);

    // Create error table
    createTable($("#errorsTable"), {"supportsControllersDiscrimination": false, "titles": ["Type of error", "Number of errors", "% in errors", "% in all samples"], "items": [{"data": ["Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: geeksforgeeks.org:443 failed to respond", 5, 0.06232859636000997, 0.03550632012498225], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: www.hollandandbarrett.com:443 failed to respond", 16, 0.1994515083520319, 0.1136202243999432], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: hollandandbarrett.com:443 failed to respond", 5, 0.06232859636000997, 0.03550632012498225], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: geeksforgeeks.org", 1961, 24.44527549239591, 13.925578753018037], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: petstore.octoperf.com", 1964, 24.482672650211917, 13.946882545093027], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: hollandandbarrett.com", 1960, 24.43280977312391, 13.918477488993041], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: practicetestautomation.com", 1769, 22.051857392171527, 12.56213606021872], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (petstore.octoperf.com)", 3, 0.037397157816005985, 0.021303792074989347], "isController": false}, {"data": ["Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 216, 2.6925953627524306, 1.533873029399233], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (practicetestautomation.com)", 1, 0.012465719272001994, 0.00710126402499645], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: practicetestautomation.com:443 failed to respond", 12, 0.14958863126402394, 0.08521516829995739], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: www.easycalculation.com:443 failed to respond", 22, 0.2742458239840439, 0.15622780854992188], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: www.geeksforgeeks.org:443 failed to respond", 16, 0.1994515083520319, 0.1136202243999432], "isController": false}, {"data": ["Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: petstore.octoperf.com:443 failed to respond", 13, 0.16205435053602593, 0.09231643232495385], "isController": false}, {"data": ["Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 18, 0.2243829468960359, 0.1278227524499361], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.geeksforgeeks.org", 6, 0.07479431563201197, 0.04260758414997869], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (geeksforgeeks.org)", 6, 0.07479431563201197, 0.04260758414997869], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (www.geeksforgeeks.org)", 4, 0.049862877088007976, 0.0284050560999858], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (hollandandbarrett.com)", 5, 0.06232859636000997, 0.03550632012498225], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (www.hollandandbarrett.com)", 2, 0.024931438544003988, 0.0142025280499929], "isController": false}, {"data": ["Non HTTP response code: java.net.SocketException/Non HTTP response message: A connection attempt failed because the connected party did not properly respond after a period of time, or established connection failed because connected host has failed to respond", 8, 0.09972575417601595, 0.0568101121999716], "isController": false}, {"data": ["Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.hollandandbarrett.com", 10, 0.12465719272001995, 0.0710126402499645], "isController": false}]}, function(index, item){
        switch(index){
            case 2:
            case 3:
                item = item.toFixed(2) + '%';
                break;
        }
        return item;
    }, [[1, 1]]);

        // Create top5 errors by sampler
    createTable($("#top5ErrorsBySamplerTable"), {"supportsControllersDiscrimination": false, "overall": {"data": ["Total", 14082, 8022, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: petstore.octoperf.com", 1964, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: geeksforgeeks.org", 1961, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: hollandandbarrett.com", 1960, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: practicetestautomation.com", 1769, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 216], "isController": false}, "titles": ["Sample", "#Samples", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors", "Error", "#Errors"], "items": [{"data": ["JAVA", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: geeksforgeeks.org", 400, "", "", "", "", "", "", "", ""], "isController": false}, {"data": ["JAVASCRIPT", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: geeksforgeeks.org", 400, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": ["NEW", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: hollandandbarrett.com", 396, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (hollandandbarrett.com)", 4, "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": ["CATS", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: petstore.octoperf.com", 400, "", "", "", "", "", "", "", ""], "isController": false}, {"data": ["Practice test login excercise", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: practicetestautomation.com", 359, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 35, "Non HTTP response code: java.net.SocketException/Non HTTP response message: A connection attempt failed because the connected party did not properly respond after a period of time, or established connection failed because connected host has failed to respond", 5, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (practicetestautomation.com)", 1, "", ""], "isController": false}, {"data": ["Practice Test Exception", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: practicetestautomation.com", 360, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 40, "", "", "", "", "", ""], "isController": false}, {"data": ["VITAMINS&SUPPLEMENTS", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: hollandandbarrett.com", 400, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": ["Practice", 400, 392, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: practicetestautomation.com", 346, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 46, "", "", "", "", "", ""], "isController": false}, {"data": ["Courses", 400, 394, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: practicetestautomation.com", 359, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 33, "Non HTTP response code: java.net.SocketException/Non HTTP response message: A connection attempt failed because the connected party did not properly respond after a period of time, or established connection failed because connected host has failed to respond", 2, "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["DOGS", 400, 397, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: petstore.octoperf.com", 395, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: petstore.octoperf.com:443 failed to respond", 1, "Non HTTP response code: java.net.SocketException/Non HTTP response message: A connection attempt failed because the connected party did not properly respond after a period of time, or established connection failed because connected host has failed to respond", 1, "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": ["HOME-1", 430, 41, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 14, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: www.easycalculation.com:443 failed to respond", 11, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: www.hollandandbarrett.com:443 failed to respond", 8, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: www.geeksforgeeks.org:443 failed to respond", 8, "", ""], "isController": false}, {"data": [], "isController": false}, {"data": ["Home", 400, 392, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: practicetestautomation.com", 345, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 34, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: practicetestautomation.com:443 failed to respond", 12, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 1, "", ""], "isController": false}, {"data": ["OFFERS", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: hollandandbarrett.com", 384, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 9, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.hollandandbarrett.com", 5, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (hollandandbarrett.com)", 1, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (www.hollandandbarrett.com)", 1], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["DATA sCIENCE-1", 5, 5, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.geeksforgeeks.org", 3, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (www.geeksforgeeks.org)", 2, "", "", "", "", "", ""], "isController": false}, {"data": ["DATA sCIENCE", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: geeksforgeeks.org", 385, "Non HTTP response code: java.net.SocketException/Non HTTP response message: Connection reset", 8, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.geeksforgeeks.org", 3, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (geeksforgeeks.org)", 2, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (www.geeksforgeeks.org)", 2], "isController": false}, {"data": ["OFFERS-1", 6, 6, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: www.hollandandbarrett.com", 5, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (www.hollandandbarrett.com)", 1, "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": ["TRENDING", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: hollandandbarrett.com", 400, "", "", "", "", "", "", "", ""], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": [], "isController": false}, {"data": ["FISH", 400, 392, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: petstore.octoperf.com", 391, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (petstore.octoperf.com)", 1, "", "", "", "", "", ""], "isController": false}, {"data": ["C programming", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: geeksforgeeks.org", 396, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (geeksforgeeks.org)", 4, "", "", "", "", "", ""], "isController": false}, {"data": ["REPTILES", 400, 400, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: petstore.octoperf.com", 398, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: No such host is known (petstore.octoperf.com)", 2, "", "", "", "", "", ""], "isController": false}, {"data": ["HOme", 400, 392, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: petstore.octoperf.com", 380, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: petstore.octoperf.com:443 failed to respond", 12, "", "", "", "", "", ""], "isController": false}, {"data": ["HOME", 1200, 811, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: geeksforgeeks.org", 380, "Non HTTP response code: java.net.UnknownHostException/Non HTTP response message: hollandandbarrett.com", 380, "Non HTTP response code: javax.net.ssl.SSLHandshakeException/Non HTTP response message: Remote host terminated the handshake", 14, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: www.easycalculation.com:443 failed to respond", 11, "Non HTTP response code: org.apache.http.NoHttpResponseException/Non HTTP response message: www.hollandandbarrett.com:443 failed to respond", 8], "isController": false}]}, function(index, item){
        return item;
    }, [[0, 0]], 0);

});
