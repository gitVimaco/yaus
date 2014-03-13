package yaus

class StatsController {
    static MAX_RESULTS = 10

    def index() {
        def criteria = Visit.createCriteria()

        if (!params.max) params.max = MAX_RESULTS
        if (!params.offset) params.offset = 0

        def visits = criteria.list(params) {
            projections {
                groupProperty('link')
                rowCount('visitCount')
            }
            if (!params.order)
                order('visitCount','desc')
        }

        // Really ugly solution but visits.totalCount is returning the total number of Visits and not the number of results returned by the query
        def rowCount = Visit.createCriteria().list() {
            projections {
                groupProperty('link')
                rowCount('visitCount')
            }
        }

        [visits: visits, rowCount: rowCount.size(), maxResults: MAX_RESULTS]
    }
}
